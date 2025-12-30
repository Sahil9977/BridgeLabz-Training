// Q16_QueueTypes.java
// Demonstrate different types of queues in Java
package Collection;

import java.util.*;

public class QueueTypes {
    public static void main(String[] args) {
        // Simple Queue
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        queue.offer(2);
        System.out.println(queue.poll()); // 1

        // Deque
        Deque<Integer> deque = new ArrayDeque<>();
        deque.offerFirst(10);
        deque.offerLast(20);
        System.out.println(deque.pollFirst()); // 10
        System.out.println(deque.pollLast()); // 20

        // Priority Queue
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.offer(5);
        pq.offer(1);
        pq.offer(3);
        System.out.println(pq.poll()); // 1
    }
}
