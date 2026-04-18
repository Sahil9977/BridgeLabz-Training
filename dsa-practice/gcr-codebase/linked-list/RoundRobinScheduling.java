// Q6_RoundRobinScheduling.java
// Circular Linked List: Round Robin Scheduling Algorithm
package linked_list;

import java.util.Scanner;

class Process {
    int processId;
    int burstTime;
    int priority;
    int waitingTime;
    int turnAroundTime;
    Process next;

    public Process(int processId, int burstTime, int priority) {
        this.processId = processId;
        this.burstTime = burstTime;
        this.priority = priority;
        this.waitingTime = 0;
        this.turnAroundTime = 0;
        this.next = null;
    }
}

public class RoundRobinScheduling {
    private Process head = null;

    public void addAtEnd(int processId, int burstTime, int priority) {
        Process newProcess = new Process(processId, burstTime, priority);
        if (head == null) {
            head = newProcess;
            newProcess.next = head;
        } else {
            Process temp = head;
            while (temp.next != head) temp = temp.next;
            temp.next = newProcess;
            newProcess.next = head;
        }
    }

    public void removeByProcessId(int processId) {
        if (head == null) return;
        if (head.processId == processId && head.next == head) {
            head = null;
            return;
        }
        Process curr = head, prev = null;
        do {
            if (curr.processId == processId) {
                if (curr == head) {
                    Process temp = head;
                    while (temp.next != head) temp = temp.next;
                    head = head.next;
                    temp.next = head;
                } else {
                    prev.next = curr.next;
                }
                return;
            }
            prev = curr;
            curr = curr.next;
        } while (curr != head);
    }

    public void displayAll() {
        if (head == null) {
            System.out.println("No processes in the queue.");
            return;
        }
        Process temp = head;
        System.out.println("PID\tBurst\tPriority");
        do {
            System.out.println(temp.processId + "\t" + temp.burstTime + "\t" + temp.priority);
            temp = temp.next;
        } while (temp != head);
    }

    public void simulateRoundRobin(int quantum) {
        if (head == null) {
            System.out.println("No processes to schedule.");
            return;
        }
        int n = 0;
        Process temp = head;
        do {
            n++;
            temp = temp.next;
        } while (temp != head);
        int[] waitingTime = new int[n];
        int[] turnAroundTime = new int[n];
        int[] burst = new int[n];
        int[] pid = new int[n];
        int idx = 0;
        temp = head;
        do {
            burst[idx] = temp.burstTime;
            pid[idx] = temp.processId;
            idx++;
            temp = temp.next;
        } while (temp != head);
        int time = 0;
        boolean done;
        do {
            done = true;
            for (int i = 0; i < n; i++) {
                if (burst[i] > 0) {
                    done = false;
                    if (burst[i] > quantum) {
                        time += quantum;
                        burst[i] -= quantum;
                    } else {
                        time += burst[i];
                        waitingTime[i] = time - burst[i];
                        burst[i] = 0;
                    }
                }
            }
        } while (!done);
        for (int i = 0; i < n; i++) {
            turnAroundTime[i] = waitingTime[i] + (head == null ? 0 : getBurstTimeById(pid[i]));
        }
        System.out.println("PID\tWaiting\tTurnAround");
        for (int i = 0; i < n; i++) {
            System.out.println(pid[i] + "\t" + waitingTime[i] + "\t" + turnAroundTime[i]);
        }
        double avgWait = 0, avgTurn = 0;
        for (int i = 0; i < n; i++) {
            avgWait += waitingTime[i];
            avgTurn += turnAroundTime[i];
        }
        System.out.println("Average Waiting Time: " + (avgWait / n));
        System.out.println("Average Turnaround Time: " + (avgTurn / n));
    }

    private int getBurstTimeById(int processId) {
        if (head == null) return 0;
        Process temp = head;
        do {
            if (temp.processId == processId) return temp.burstTime;
            temp = temp.next;
        } while (temp != head);
        return 0;
    }

    public static void main(String[] args) {
        RoundRobinScheduling rr = new RoundRobinScheduling();
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\n1. Add Process\n2. Remove by Process ID\n3. Display All\n4. Simulate Round Robin\n0. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter Process ID: ");
                    int pid = sc.nextInt();
                    System.out.print("Enter Burst Time: ");
                    int bt = sc.nextInt();
                    System.out.print("Enter Priority: ");
                    int pr = sc.nextInt();
                    rr.addAtEnd(pid, bt, pr);
                    break;
                case 2:
                    System.out.print("Enter Process ID to remove: ");
                    int rid = sc.nextInt();
                    rr.removeByProcessId(rid);
                    break;
                case 3:
                    rr.displayAll();
                    break;
                case 4:
                    System.out.print("Enter Time Quantum: ");
                    int q = sc.nextInt();
                    rr.simulateRoundRobin(q);
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 0);
        sc.close();
    }
}
