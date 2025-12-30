// Q13_UndoFunctionality.java
// Simple undo functionality using Stack
package Collection;

import java.util.Stack;

public class UndoFunctionality {
    private Stack<String> history = new Stack<>();
    private String current = "";

    public void type(String text) {
        history.push(current);
        current += text;
    }

    public void undo() {
        if (!history.isEmpty()) {
            current = history.pop();
        }
    }

    public String getText() {
        return current;
    }

    public static void main(String[] args) {
        UndoFunctionality editor = new UndoFunctionality();
        editor.type("Hello");
        editor.type(" World");
        System.out.println(editor.getText()); // Hello World
        editor.undo();
        System.out.println(editor.getText()); // Hello
    }
}
