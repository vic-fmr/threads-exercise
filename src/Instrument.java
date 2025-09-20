import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class Instrument implements Runnable {

    private final String name;
    private int bpm;
    private final String audioFilePath;
    private Clip audioClip;
    private FloatControl gainControl;

    private volatile boolean isPlaying = false;
    private volatile boolean isRunning = true;

    public Instrument(String name, String audioFilePath, int bpm) {
        this.name = name;
        this.audioFilePath = audioFilePath;
        this.bpm = bpm;
    }


    @Override
    public void run() {
        loadAudio();
        if (audioClip == null) {
            return;
        }


        audioClip.setFramePosition(0);
        audioClip.loop(Clip.LOOP_CONTINUOUSLY);


        pause();


        while (isRunning) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                isRunning = false;
            }
        }

        audioClip.stop();
        audioClip.close();
    }


    public synchronized boolean isPlaying() {
        return isPlaying;

    }


    public synchronized void play() {
        if (gainControl != null) {
            gainControl.setValue(0.0f);
            this.isPlaying = true;
        }
    }

    public synchronized void pause() {
        if (gainControl != null) {
            gainControl.setValue(-80.0f);
            this.isPlaying = false;
        }
    }

    public synchronized void stop() {
        this.isRunning = false;
    }
    
    public synchronized void setBpm(int bpm) {
        if (bpm > 0) {
            this.bpm = bpm;
        }
    }

    public String getName() {
        return this.name;
    }

    public int getBpm(){
        return this.bpm;
    }

    private void loadAudio() {
        try {
            File audioFile = new File(audioFilePath);
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
            audioClip = AudioSystem.getClip();
            audioClip.open(audioStream);

            if (audioClip.isControlSupported(FloatControl.Type.MASTER_GAIN)) {
                gainControl = (FloatControl) audioClip.getControl(FloatControl.Type.MASTER_GAIN);
            }

        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.err.println("Erro ao carregar o arquivo de áudio: " + e.getMessage());
            e.printStackTrace();
        }
    }
}