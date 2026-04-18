// Q8_UndoRedoTextEditor.java
// Doubly Linked List: Undo/Redo Functionality for Text Editor
package linked_list;

import java.util.Scanner;

class TextState {
    String content;
    TextState prev, next;

    public TextState(String content) {
        this.content = content;
        this.prev = null;
        this.next = null;
    }
}

public class UndoRedoTextEditor {
    private TextState head, tail, current;
    private int size = 0;
    private final int MAX_HISTORY = 10;

    public void addState(String content) {
        TextState newState = new TextState(content);
        if (head == null) {
            head = tail = current = newState;
            size = 1;
        } else {
            // Remove all redo states
            if (current != tail) {
                TextState temp = current.next;
                while (temp != null) {
                    TextState next = temp.next;
                    temp.prev = temp.next = null;
                    temp = next;
                    size--;
                }
                current.next = null;
                tail = current;
            }
            tail.next = newState;
            newState.prev = tail;
            tail = newState;
            current = newState;
            size++;
            // Limit history size
            if (size > MAX_HISTORY) {
                head = head.next;
                head.prev = null;
                size--;
            }
        }
    }

    public void undo() {
        if (current != null && current.prev != null) {
            current = current.prev;
            System.out.println("Undo performed.");
        } else {
            System.out.println("No more undo available.");
        }
    }

    public void redo() {
        if (current != null && current.next != null) {
            current = current.next;
            System.out.println("Redo performed.");
        } else {
            System.out.println("No more redo available.");
        }
    }

    public void displayCurrent() {
        if (current == null) {
            System.out.println("No text state available.");
        } else {
            System.out.println("Current Text: " + current.content);
        }
    }

    public void displayHistory() {
        TextState temp = head;
        int idx = 1;
        while (temp != null) {
            System.out.println(idx + ": " + temp.content + (temp == current ? " <- current" : ""));
            temp = temp.next;
            idx++;
        }
    }

    public static void main(String[] args) {
        UndoRedoTextEditor editor = new UndoRedoTextEditor();
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\n1. Type/Add State\n2. Undo\n3. Redo\n4. Display Current\n5. Display History\n0. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    System.out.print("Enter new text: ");
                    String text = sc.nextLine();
                    editor.addState(text);
                    break;
                case 2:
                    editor.undo();
                    break;
                case 3:
                    editor.redo();
                    break;
                case 4:
                    editor.displayCurrent();
                    break;
                case 5:
                    editor.displayHistory();
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
