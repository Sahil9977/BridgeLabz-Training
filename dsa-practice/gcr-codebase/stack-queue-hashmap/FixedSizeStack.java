// Q15_FixedSizeStack.java
// Fixed-size stack with overflow/underflow checks
package Collection;

public class FixedSizeStack {
    private int[] arr;
    private int top;
    private int capacity;

    public FixedSizeStack(int size) {
        arr = new int[size];
        capacity = size;
        top = -1;
    }

    public void push(int x) {
        if (top == capacity - 1) throw new RuntimeException("Stack Overflow");
        arr[++top] = x;
    }

    public int pop() {
        if (top == -1) throw new RuntimeException("Stack Underflow");
        return arr[top--];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public static void main(String[] args) {
        FixedSizeStack stack = new FixedSizeStack(2);
        stack.push(10);
        stack.push(20);
        // stack.push(30); // Uncomment to see overflow
        System.out.println(stack.pop()); // 20
        System.out.println(stack.pop()); // 10
        // System.out.println(stack.pop()); // Uncomment to see underflow
    }
}
