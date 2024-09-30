import java.util.ArrayList;
import java.util.Random;

// Class representing a simple queue
class SimpleQueue {
    private ArrayList<Integer> elements; // ArrayList to hold the queue elements

    // Constructor to initialize the queue
    public SimpleQueue() {
        elements = new ArrayList<>(); // Initialize the ArrayList
    }

    // Method to add an element to the end of the queue
    public void enqueue(int value) throws QueueIsFull {
        elements.add(value); // Add the element to the end
    }

    // Method to remove and return the front element of the queue
    public int dequeue() {
        if (!isEmpty()) { // Check if the queue is not empty
            return elements.remove(0); // Remove and return the front element
        } else {
            System.out.println("Queue is empty"); // Inform the user
            return -1; // Return -1 if the queue is empty
        }
    }

    // Method to return the front element without removing it
    public int front() {
        if (!isEmpty()) { // Check if the queue is not empty
            return elements.get(0); // Return the front element
        } else {
            System.out.println("Queue is empty"); // Inform the user
            return -1; // Return -1 if the queue is empty
        }
    }

    // Method to check if the queue is empty
    public boolean isEmpty() {
        return elements.isEmpty(); // Return true if the queue is empty
    }
}

// Example usage of the SimpleQueue class
public class ArrayQueue {
    public static void automatedTest(SimpleQueue queue, int capacity) throws Exception {
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
        SimpleQueue queue = new SimpleQueue(); // Create a new queue
        long start = System.currentTimeMillis();

        automatedTest(queue, 100000);
        System.out.println("Time taken = " + (System.currentTimeMillis() - start));


    }
}
