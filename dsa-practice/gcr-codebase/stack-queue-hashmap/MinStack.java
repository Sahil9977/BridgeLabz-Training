// Q12_MinStack.java
// Stack with O(1) getMin operation using auxiliary stack
package Collection;

import java.util.Stack;

public class MinStack {
    private Stack<Integer> stack = new Stack<>();
    private Stack<Integer> minStack = new Stack<>();

    public void push(int x) {
        stack.push(x);
        if (minStack.isEmpty() || x <= minStack.peek()) {
            minStack.push(x);
        }
    }

    public int pop() {
        int val = stack.pop();
        if (val == minStack.peek()) {
            minStack.pop();
        }
        return val;
    }

    public int getMin() {
        return minStack.peek();
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(3);
        minStack.push(5);
        System.out.println(minStack.getMin()); // 3
        minStack.push(2);
        minStack.push(1);
        System.out.println(minStack.getMin()); // 1
        minStack.pop();
        System.out.println(minStack.getMin()); // 2
    }
}
