// Instrument.java
public class Instrument implements Runnable {

    private final String name;
    private int bpm;

    private volatile boolean isPlaying = false;
    private volatile boolean isRunning = true;

    public Instrument(String name, int bpm) {
        this.name = name;
        this.bpm = bpm;
    }

    @Override
    public void run() {
        while (isRunning) {
            try {
                if (isPlaying) {
                    // Simula o "trabalho" de tocar a música.
                    // O cálculo do tempo continua, mas sem imprimir nada aqui.
                    long sleepTime = 60000 / bpm;
                    Thread.sleep(sleepTime);
                } else {
                    // Se estiver pausado, espera um pouco para não sobrecarregar a CPU
                    Thread.sleep(100);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                isRunning = false;
            }
        }
    }

    // Métodos de controle (sincronizados para segurança entre threads)
    public synchronized void setPlaying(boolean playing) {
        this.isPlaying = playing;
    }

    public synchronized boolean isPlaying() {
        return isPlaying;
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
}