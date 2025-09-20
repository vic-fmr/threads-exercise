// StatusController.java
import java.util.Scanner;

public class StatusController implements Runnable {
    private final InstrumentController controller;
    private final Scanner scanner = new Scanner(System.in);

    public StatusController(InstrumentController controller) {
        this.controller = controller;
    }

    @Override
    public void run() {
        String command = "";
        while (!command.equals("exit")) {
            // 1. LIMPA E EXIBE O STATUS
            clearConsole();
            displayStatus();

            // 2. PEDE O INPUT
            System.out.println("\nComandos: \nplay <nome> \npause <nome> \nbpm <nome> <valor> \nadd <nome> <bpm>\nexit");
            System.out.print("\nDJ > ");

            String line = scanner.nextLine();
            String[] parts = line.trim().split(" ");
            if (parts.length == 0 || parts[0].isEmpty()) continue;

            command = parts[0].toLowerCase();
            
            // 3. PROCESSA O COMANDO
            processCommand(command, parts);
        }

        controller.stopAll();
        scanner.close();
        System.out.println("Mesa de DJ desligada.");
    }

    private void displayStatus() {
        System.out.println("--- MESA DE DJ ---");
        for (Instrument instrument : controller.getInstruments().values()) {
            String status = instrument.isPlaying() ? "TOCANDO :) " : "PAUSADO ||";
            System.out.println(instrument.getName() + ": " + status + "BPM: " + instrument.getBpm());
        }
        System.out.println("------------------------------------");
    }

    private void processCommand(String command, String[] parts) {
        if (command.equals("exit")) return;
        
        if (parts.length < 2) {
            // Pode adicionar uma mensagem de erro aqui se quiser
            return;
        }
        String instrumentName = parts[1];

        switch (command) {
            case "play":
                controller.play(instrumentName);
                break;
            case "pause":
                controller.pause(instrumentName);
                break;
            case "add":
                if (parts.length == 3) {
                    try {
                        int bpm = Integer.parseInt(parts[2]);
                        controller.addInstrument(instrumentName, bpm);
                    } catch (NumberFormatException e) {
                        // Tratar erro
                    }
                }
                break;
            case "bpm":
                if (parts.length == 3) {
                    try {
                        int bpm = Integer.parseInt(parts[2]);
                        controller.setBpm(instrumentName, bpm);
                    } catch (NumberFormatException e) {
                        // Tratar erro
                    }
                }
                break;
        }
    }

    private void clearConsole() {
        // Funciona na maioria dos terminais.
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}