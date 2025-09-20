// InstrumentController.java
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class InstrumentController {

    private final Map<String, Instrument> instruments = new ConcurrentHashMap<>();
    private final Map<String, Thread> instrumentThreads = new ConcurrentHashMap<>();

    public InstrumentController() {
        addInstrument("baixo","music/bass.wav", 80);
        addInstrument("bateria","music/drums.wav", 80);
        addInstrument("melodia","music/melody.wav", 80);
        addInstrument("diva", "music/vocal.wav", 80);
    }

    public void startAll() {
            for (Instrument instrument : instruments.values()) {
                Thread t = new Thread(instrument);
                t.start();
                instrumentThreads.put(instrument.getName(), t);
            }

    }

    public void stopAll() {
        for (Instrument instrument : instruments.values()) {
            instrument.stop();
        }
        System.out.println("\nAguardando as faixas finalizarem...");
    }

    private void addInstrument(String name, String audioPath, int bpm) {
        if (!instruments.containsKey(name)) {
            Instrument newInstrument = new Instrument(name, audioPath, bpm);
            instruments.put(name, newInstrument);
        }
    }

    public void play(String instrumentName) {


        Instrument instrument = instruments.get(instrumentName);
        if (instrument != null) {
            instrument.play();
        } else {
            System.out.println("Instrumento não encontrado.");
        }
    }

    public void pause(String instrumentName) {
        Instrument instrument = instruments.get(instrumentName);
        if (instrument != null) {
            instrument.pause();
        } else {
            System.out.println("Instrumento não encontrado.");
        }
    }

    public void setBpm(String instrumentName, int bpm) {
        Instrument instrument = instruments.get(instrumentName);
        if (instrument != null) {
            instrument.setBpm(bpm);
        }
    }

    public Map<String, Instrument> getInstruments() {
        return instruments;
    }
}