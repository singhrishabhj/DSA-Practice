import java.util.Random;

class QueueIsEmpty extends Exception {}
class QueueIsFull extends Exception {}

class CircularArrayQueue {
    private int[] queue;
    private int front;
    private int rear;
    private int size;
    private int capacity;

    // Constructor to initialize the queue with a given capacity
    public CircularArrayQueue(int capacity) {
        this.capacity = capacity;
        queue = new int[capacity];
        front = -1;
        rear = -1;
        size = 0;
    }

    // Add an element to the end of the queue
    public void enqueue(int x) throws QueueIsFull {
        if (isFull()) {
            System.out.println("Queue is full");
            throw new QueueIsFull();
        }

        // Move rear pointer circularly
        rear = (rear + 1) % capacity;
        queue[rear] = x;

        // If first element is being added, set front to 0
        if (front == -1) {
            front = rear;
        }

        size++;
    }

    // Remove and return the front element of the queue
    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }

        int result = queue[front];

        // Move front pointer circularly
        front = (front + 1) % capacity;
        size--;

        // Reset front and rear if the queue becomes empty
        if (size == 0) {
            front = -1;
            rear = -1;
        }

        return result;
    }

    // Return the front element without removing it
    public int front() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }

        return queue[front];
    }

    // Check if the queue is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Check if the queue is full
    public boolean isFull() {
        return size == capacity;
    }
}

// Example usage
public class CircularArrayQueueMain {

    public static void manualTest(CircularArrayQueue queue, int capacity) throws Exception {
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);
        queue.enqueue(50);

        System.out.println("Dequeue: " + queue.dequeue());  // Output: 10
        System.out.println("Front: " + queue.front());      // Output: 20

        queue.enqueue(60);  // This will be added to the queue because it's circular

        System.out.println("Dequeue: " + queue.dequeue());  // Output: 20
        System.out.println("Dequeue: " + queue.dequeue());  // Output: 30
        System.out.println("Dequeue: " + queue.dequeue());  // Output: 40
        System.out.println("Dequeue: " + queue.dequeue());  // Output: 50
        System.out.println("Dequeue: " + queue.dequeue());  // Output: 60

        System.out.println("Is Queue Empty: " + queue.isEmpty());  // Output: true
    }

    public static void automatedTest(CircularArrayQueue queue, int capacity) throws Exception {
        Random random = new Random();
        int size = 0;
        for (int i = 1; i <= capacity * 2; i++) {
            if (random.nextBoolean()) {
                try {
                    queue.enqueue(i);
                } catch (QueueIsFull exception) {
                    break;
                }
                size++;
            }
        }


        Integer lastSeen = Integer.MIN_VALUE;
        while (!queue.isEmpty()) {
            Integer element = queue.dequeue();

            if (element < lastSeen) {
                throw new RuntimeException("Test failed: ordering");
            }
            lastSeen = element;
            System.out.println(element);
            size--;
        }

        if (size != 0) {
            throw new RuntimeException("Test failed : size mismatched");
        }
    }
    public static void main(String[] args) throws Exception {
        int capacity = 100000;
        CircularArrayQueue queue = new CircularArrayQueue(capacity); // Queue with a capacity of 5
        long start = System.currentTimeMillis();
        automatedTest(queue, capacity);
        System.out.println("Time taken = " + (System.currentTimeMillis() - start));

    }
}
