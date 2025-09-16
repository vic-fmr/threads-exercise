import java.util.Scanner;

public class StatusController implements Runnable {
    InstrumentController controller = new InstrumentController();
    Scanner scanner = new Scanner(System.in);
    String command = "";
    String instrument;

    @Override
    public void run(){
        while (!command.equals("exit")){
            try {


                clean();

                status();

                System.out.println("-----------");
                System.out.print("DJ > ");

                String[] input = scanner.nextLine().split(" ");

                if (input.length == 2){
                    command = input[0];
                    instrument = input[1];
                } else {
                    System.out.println("Comando Inválido. Tente 'play/pause instrumento' ");
                    continue;
                }


                switch (command) {
                    case "play":
                        controller.play(instrument);
                        break;

                    case "pause":
                        controller.pause(instrument);
                        break;

                    case "exit":
                        break;

                    default:
                        System.out.println("-----------");
                        System.out.println("Comando Inválido. Tente 'play/pause instrumento' ");
                }

                Thread.sleep(100);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }

        scanner.close();
    }

    private void status(){
        clean();

        System.out.println("--- Instrumentos Tocando ---");

        for (Instrument instrument : controller.getInstruments().values()){
            System.out.println(instrument.getName() + ":" + (instrument.isPlaying() ? "TOCANDO ♪♩" : "PAUSADO || "));
        }
    }

    private void clean() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
