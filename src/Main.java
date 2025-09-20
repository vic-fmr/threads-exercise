public class Main {
    public static void main(String[] args) {

        InstrumentController controller = new InstrumentController();
        controller.startAll();


        StatusController consoleUi = new StatusController(controller);
        Thread uiThread = new Thread(consoleUi);
        uiThread.start();
    }
}