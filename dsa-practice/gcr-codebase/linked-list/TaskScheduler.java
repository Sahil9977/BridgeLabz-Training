// Q3_TaskScheduler.java
// Circular Linked List: Task Scheduler
package linked_list;

import java.util.Scanner;

class Task {
    int taskId;
    String taskName;
    int priority;
    String dueDate;
    Task next;

    public Task(int taskId, String taskName, int priority, String dueDate) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.priority = priority;
        this.dueDate = dueDate;
        this.next = null;
    }
}

public class TaskScheduler {
    private Task head = null;

    public void addAtBeginning(int taskId, String taskName, int priority, String dueDate) {
        Task newTask = new Task(taskId, taskName, priority, dueDate);
        if (head == null) {
            head = newTask;
            newTask.next = head;
        } else {
            Task temp = head;
            while (temp.next != head) temp = temp.next;
            newTask.next = head;
            temp.next = newTask;
            head = newTask;
        }
    }

    public void addAtEnd(int taskId, String taskName, int priority, String dueDate) {
        Task newTask = new Task(taskId, taskName, priority, dueDate);
        if (head == null) {
            head = newTask;
            newTask.next = head;
        } else {
            Task temp = head;
            while (temp.next != head) temp = temp.next;
            temp.next = newTask;
            newTask.next = head;
        }
    }

    public void addAtPosition(int pos, int taskId, String taskName, int priority, String dueDate) {
        if (pos <= 1 || head == null) {
            addAtBeginning(taskId, taskName, priority, dueDate);
            return;
        }
        Task temp = head;
        int count = 1;
        while (count < pos - 1 && temp.next != head) {
            temp = temp.next;
            count++;
        }
        Task newTask = new Task(taskId, taskName, priority, dueDate);
        newTask.next = temp.next;
        temp.next = newTask;
    }

    public void removeByTaskId(int taskId) {
        if (head == null) return;
        if (head.taskId == taskId && head.next == head) {
            head = null;
            return;
        }
        Task curr = head, prev = null;
        do {
            if (curr.taskId == taskId) {
                if (curr == head) {
                    Task temp = head;
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

    public Task searchByPriority(int priority) {
        if (head == null) return null;
        Task temp = head;
        do {
            if (temp.priority == priority) return temp;
            temp = temp.next;
        } while (temp != head);
        return null;
    }

    public void displayAll() {
        if (head == null) {
            System.out.println("No tasks in the list.");
            return;
        }
        Task temp = head;
        System.out.println("TaskID\tTaskName\tPriority\tDueDate");
        do {
            System.out.println(temp.taskId + "\t" + temp.taskName + "\t" + temp.priority + "\t" + temp.dueDate);
            temp = temp.next;
        } while (temp != head);
    }

    public void viewCurrentAndMoveNext() {
        if (head == null) {
            System.out.println("No tasks in the list.");
            return;
        }
        System.out.println("Current Task: " + head.taskId + ", " + head.taskName + ", " + head.priority + ", " + head.dueDate);
        head = head.next;
    }

    public static void main(String[] args) {
        TaskScheduler scheduler = new TaskScheduler();
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\n1. Add at Beginning\n2. Add at End\n3. Add at Position\n4. Remove by Task ID\n5. View Current & Move Next\n6. Display All\n7. Search by Priority\n0. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    System.out.print("Enter Task ID: ");
                    int t1 = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Task Name: ");
                    String n1 = sc.nextLine();
                    System.out.print("Enter Priority: ");
                    int p1 = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Due Date: ");
                    String d1 = sc.nextLine();
                    scheduler.addAtBeginning(t1, n1, p1, d1);
                    break;
                case 2:
                    System.out.print("Enter Task ID: ");
                    int t2 = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Task Name: ");
                    String n2 = sc.nextLine();
                    System.out.print("Enter Priority: ");
                    int p2 = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Due Date: ");
                    String d2 = sc.nextLine();
                    scheduler.addAtEnd(t2, n2, p2, d2);
                    break;
                case 3:
                    System.out.print("Enter Position: ");
                    int pos = sc.nextInt();
                    System.out.print("Enter Task ID: ");
                    int t3 = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Task Name: ");
                    String n3 = sc.nextLine();
                    System.out.print("Enter Priority: ");
                    int p3 = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Due Date: ");
                    String d3 = sc.nextLine();
                    scheduler.addAtPosition(pos, t3, n3, p3, d3);
                    break;
                case 4:
                    System.out.print("Enter Task ID to remove: ");
                    int rid = sc.nextInt();
                    scheduler.removeByTaskId(rid);
                    break;
                case 5:
                    scheduler.viewCurrentAndMoveNext();
                    break;
                case 6:
                    scheduler.displayAll();
                    break;
                case 7:
                    System.out.print("Enter Priority to search: ");
                    int sp = sc.nextInt();
                    Task found = scheduler.searchByPriority(sp);
                    if (found != null) {
                        System.out.println("Found: " + found.taskId + ", " + found.taskName + ", " + found.priority + ", " + found.dueDate);
                    } else {
                        System.out.println("Task not found.");
                    }
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
