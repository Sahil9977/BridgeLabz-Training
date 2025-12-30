// Q17_CircularQueue.java
// Circular queue implementation with memory optimization
package Collection;

public class CircularQueue {
    private int[] arr;
    private int head, tail, size, capacity;

    public CircularQueue(int k) {
        arr = new int[k];
        capacity = k;
        head = 0;
        tail = 0;
        size = 0;
    }

    public boolean enqueue(int x) {
        if (size == capacity) return false;
        arr[tail] = x;
        tail = (tail + 1) % capacity;
        size++;
        return true;
    }

    public int dequeue() {
        if (size == 0) throw new RuntimeException("Queue Underflow");
        int val = arr[head];
        head = (head + 1) % capacity;
        size--;
        return val;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public static void main(String[] args) {
        CircularQueue cq = new CircularQueue(2);
        cq.enqueue(1);
        cq.enqueue(2);
        // cq.enqueue(3); // Uncomment to see overflow
        System.out.println(cq.dequeue()); // 1
        System.out.println(cq.dequeue()); // 2
        // System.out.println(cq.dequeue()); // Uncomment to see underflow
    }
}
