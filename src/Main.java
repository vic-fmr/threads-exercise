// Main.java
public class Main {
    public static void main(String[] args) {
        // 1. Cria o gerenciador de instrumentos
        InstrumentController controller = new InstrumentController();

        // 2. Inicia as threads de cada instrumento (elas rodam em segundo plano)
        controller.startAll();

        // 3. Cria e inicia a thread do console, que vai gerenciar a UI
        StatusController consoleUi = new StatusController(controller);
        Thread uiThread = new Thread(consoleUi);
        uiThread.start();
    }
}