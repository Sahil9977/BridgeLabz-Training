package multi_threading;

import java.time.LocalTime;

class TaskRunner extends Thread {

    public TaskRunner(String name) {
        super(name);
    }

    public void run() {
        try {
            Thread.sleep(2000);   // TIMED_WAITING
            for (int i = 0; i < 1000000; i++); // RUNNABLE
        } catch (InterruptedException e) {}
    }
}


class StateMonitor extends Thread {
    private Thread t1, t2;

    StateMonitor(Thread t1, Thread t2) {
        this.t1 = t1;
        this.t2 = t2;
    }

    public void run() {
        while (true) {
            System.out.println("[Monitor] " + t1.getName() + " - " +
                    t1.getState() + " at " + LocalTime.now());
            System.out.println("[Monitor] " + t2.getName() + " - " +
                    t2.getState() + " at " + LocalTime.now());

            if (t1.getState() == State.TERMINATED &&
                t2.getState() == State.TERMINATED) {
                break;
            }

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {}
        }

        System.out.println("Summary: Both tasks completed");
    }
}


public class StateMonitoringSystem {
	public static void main(String[] args) {

        TaskRunner t1 = new TaskRunner("Task-1");
        TaskRunner t2 = new TaskRunner("Task-2");

        StateMonitor monitor = new StateMonitor(t1, t2);

        monitor.start();
        t1.start();
        t2.start();
    }

}
