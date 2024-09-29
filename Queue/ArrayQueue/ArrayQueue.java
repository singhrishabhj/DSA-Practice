import java.util.ArrayList;

// Class representing a simple queue
class SimpleQueue {
    private ArrayList<Integer> elements; // ArrayList to hold the queue elements

    // Constructor to initialize the queue
    public SimpleQueue() {
        elements = new ArrayList<>(); // Initialize the ArrayList
    }

    // Method to add an element to the end of the queue
    public void enqueue(int value) {
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
public class Main {
    public static void main(String[] args) {
        SimpleQueue queue = new SimpleQueue(); // Create a new queue

        // Add elements to the queue
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        // Remove and print the front element
        System.out.println("Dequeue: " + queue.dequeue()); // Output: 10

        // Print the front element
        System.out.println("Front: " + queue.front()); // Output: 20

        // Check if the queue is empty
        System.out.println("Is Queue Empty: " + queue.isEmpty()); // Output: false

        // Dequeue remaining elements
        queue.dequeue(); // Removes 20
        queue.dequeue(); // Removes 30

        // Check if the queue is empty after removing all elements
        System.out.println("Is Queue Empty: " + queue.isEmpty()); // Output: true
    }
}
