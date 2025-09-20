// InstrumentController.java
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class InstrumentController {

    private final Map<String, Instrument> instruments = new ConcurrentHashMap<>();
    private final Map<String, Thread> instrumentThreads = new ConcurrentHashMap<>();

    public InstrumentController() {
        addInstrument("guitar", 120);
        addInstrument("drum", 140);
        addInstrument("bass", 100);
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

    public void addInstrument(String name, int bpm) {
        if (!instruments.containsKey(name)) {
            Instrument newInstrument = new Instrument(name, bpm);
            instruments.put(name, newInstrument);
            Thread t = new Thread(newInstrument);
            t.start();
            instrumentThreads.put(name, t);
        }
    }

    public void play(String instrumentName) {
        Instrument instrument = instruments.get(instrumentName);
        if (instrument != null) {
            instrument.setPlaying(true);
        }
    }

    public void pause(String instrumentName) {
        Instrument instrument = instruments.get(instrumentName);
        if (instrument != null) {
            instrument.setPlaying(false);
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