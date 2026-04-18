package multi_threading;

import java.util.Random;

class DownloaderManager extends Thread {
    private String fileName;
    private Random random = new Random();

    DownloaderManager(String fileName) {
        this.fileName = fileName;
    }

    public void run() {
        try {
            for (int i = 0; i <= 100; i += 25) {
                System.out.println("[" + getName() + "] Downloading " + fileName + ": " + i + "%");
                Thread.sleep(500 + random.nextInt(500));
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) throws Exception {

        DownloaderManager t1 = new DownloaderManager("Document.pdf");
        DownloaderManager t2 = new DownloaderManager("Image.jpg");
        DownloaderManager t3 = new DownloaderManager("Video.mp4");

        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();

        System.out.println("All downloads complete!");
    }
}
