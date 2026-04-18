package functional_interface;

public class BackgroundJob {
    public static void main(String[] args) {
       
        Runnable task = () -> {
            System.out.println("Background job started...");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.getMessage();
            }
            System.out.println("Background job completed!");
        };

        Thread backgroundThread = new Thread(task);
        backgroundThread.start();

        System.out.println("Main thread continues execution...");
    }
}
