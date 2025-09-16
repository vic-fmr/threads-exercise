public class Instrument {
    private final String name;
    private boolean isPlaying;
    private int bpm;

    public Instrument(String name, int bpm) {
        this.name = name;
        this.bpm = bpm;
        this.isPlaying = false;
    }

    public String getName() {
        return name;
    }

    public int getBpm() {
        return bpm;
    }

    public void setBpm(int bpm) {
        this.bpm = bpm;
    }

    public boolean isPlaying() {
        return isPlaying;
    }

    public void setPlaying(boolean playing) {
        isPlaying = playing;
    }
}
