// Q14_ThreadSafeStack.java
// Thread-safe stack using ConcurrentLinkedDeque
package Collection;

import java.util.concurrent.ConcurrentLinkedDeque;

public class ThreadSafeStack<T> {
    private ConcurrentLinkedDeque<T> stack = new ConcurrentLinkedDeque<>();

    public void push(T x) {
        stack.push(x);
    }

    public T pop() {
        return stack.poll();
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        ThreadSafeStack<Integer> stack = new ThreadSafeStack<>();
        stack.push(1);
        stack.push(2);
        System.out.println(stack.pop()); // 2
        System.out.println(stack.pop()); // 1
    }
}
