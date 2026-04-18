package multi_threading;

class PrintJob implements Runnable {
    String name;
    int pages;

    PrintJob(String name, int pages) {
        this.name = name;
        this.pages = pages;
    }

    public void run() {
        for (int i = 1; i <= pages; i++) {
            System.out.println("Printing " + name + " - Page " + i + " of " + pages);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {}
        }
    }
}

public class JobScheduler {
    public static void main(String[] args) throws Exception {

        long start = System.currentTimeMillis();
        System.out.println("Starting print jobs...");

        Thread t1 = new Thread(new PrintJob("Job1", 10));
        Thread t2 = new Thread(new PrintJob("Job2", 5));
        Thread t3 = new Thread(new PrintJob("Job3", 15));
        Thread t4 = new Thread(new PrintJob("Job4", 8));
        Thread t5 = new Thread(new PrintJob("Job5", 12));

        t1.setPriority(5);
        t2.setPriority(8);
        t3.setPriority(3);
        t4.setPriority(6);
        t5.setPriority(7);

        t1.start(); t2.start(); t3.start(); t4.start(); t5.start();

        t1.join(); t2.join(); t3.join(); t4.join(); t5.join();

        long end = System.currentTimeMillis();
        System.out.println("All jobs completed in " + (end - start) + " ms");
    }

}
