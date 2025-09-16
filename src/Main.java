public class Main {
    public static void main(String[] args) {
        StatusController status = new StatusController();
        Thread displayThread = new Thread(status);

        displayThread.start();
    }
}