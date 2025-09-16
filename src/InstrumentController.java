import java.util.HashMap;
import java.util.Map;

public class InstrumentController {

    private Map<String, Instrument> instruments = new HashMap<>();

    public InstrumentController(){

        Instrument guitar = new Instrument("guitar", 120);
        Instrument drum = new Instrument("drum", 120);
        Instrument bass = new Instrument("bass", 120);
        Instrument seila = new Instrument("beila", 120);

        this.instruments.put(guitar.getName(), guitar);
        this.instruments.put(drum.getName(), drum);
        this.instruments.put(bass.getName(), bass);
        this.instruments.put(seila.getName(), seila);
    }

    public Map<String, Instrument> getInstruments() {
        return instruments;
    }

    public void setInstruments(Map<String, Instrument> instruments) {
        this.instruments = instruments;
    }

    public void play(String instrumentName){
        Instrument instrument = this.instruments.get(instrumentName);

        if (instrument != null)
            instrument.setPlaying(true);
    }

    public void pause(String instrumentName){
        Instrument instrument = this.instruments.get(instrumentName);

        if (instrument != null)
            instrument.setPlaying(false);
    }
}
