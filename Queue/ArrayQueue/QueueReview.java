import java.util.Random;

interface Queue<Integer> {
    void enqueue(Integer value) throws QueueIsFull;
    Integer dequeue() throws QueueIsEmpty;
    Integer front() throws QueueIsEmpty;
    boolean isEmpty();
}

class QueueIsEmpty extends Exception {}
class QueueIsFull extends Exception {}

class MyIntegerArrayQueue implements Queue<Integer> {

    Integer[] arr;
    int currentSize = 0;
    final int capacity;
    public MyIntegerArrayQueue(int len) {
        this.arr = new Integer[len];
        this.capacity = len;
    }

    @Override
    public void enqueue(Integer value) throws QueueIsFull {
        if (currentSize == capacity) {
            System.out.println("Queue found full: " + currentSize + ", " + capacity );
            throw new QueueIsFull();
        }
        arr[currentSize] = value;
        currentSize++;
    }

    @Override
    public Integer dequeue() throws QueueIsEmpty {
        if (currentSize == 0) {
            throw new QueueIsEmpty();
        }

        int val = arr[0];

        for (int i = 1; i < currentSize; i++) {
            arr[i - 1] = arr[i];
        }
        currentSize--;
        return val;
    }

    @Override
    public Integer front() throws QueueIsEmpty {
        if (currentSize == 0) {
            throw new QueueIsEmpty();
        }
        return arr[0];
    }

    @Override
    public boolean isEmpty() {
        return currentSize == 0;
    }
}


public class QueueReview {

    public static void manualTest(MyIntegerArrayQueue queue) throws Exception {
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

        System.out.println("Is Queue Empty: " + queue.isEmpty()); // Output: true
    }

    public static void automatedTest(MyIntegerArrayQueue queue, int capacity) throws Exception {
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
        int capacity = 1000;
        MyIntegerArrayQueue queue = new MyIntegerArrayQueue(capacity);
        automatedTest(queue, capacity);
    }
}
