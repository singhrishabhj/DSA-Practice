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
    public void enqueue(int x) {
        if (isFull()) {
            System.out.println("Queue is full");
            return;
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
public class Main {
    public static void main(String[] args) {
        CircularArrayQueue queue = new CircularArrayQueue(5); // Queue with a capacity of 5
        
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
}
