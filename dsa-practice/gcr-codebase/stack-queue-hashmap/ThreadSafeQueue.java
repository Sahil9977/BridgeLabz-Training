// Q18_ThreadSafeQueue.java
// Thread-safe queue using ConcurrentLinkedQueue
package Collection;

import java.util.concurrent.ConcurrentLinkedQueue;

public class ThreadSafeQueue<T> {
    private ConcurrentLinkedQueue<T> queue = new ConcurrentLinkedQueue<>();

    public void enqueue(T x) {
        queue.offer(x);
    }

    public T dequeue() {
        return queue.poll();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    public static void main(String[] args) {
        ThreadSafeQueue<Integer> queue = new ThreadSafeQueue<>();
        queue.enqueue(1);
        queue.enqueue(2);
        System.out.println(queue.dequeue()); // 1
        System.out.println(queue.dequeue()); // 2
    }
}
