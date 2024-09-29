What is a Queue?
A queue is a data structure which supports LIFO order access.

public interface Queue<Integer> {
  enqueue(Integer value) throws QueueIsFull;
  Integer dequeue() throws QueueIsEmpty;
}

public class QueueIsEmpty extends Exception {}
public class QueueIsFull extends Exception {}

Operations: 

What is an ArrayQueue?
A fixed sized array is used to implement the queue.

class ArrayQueue<T> implements Queue<T> {

  T[] arr;
  public ArrayQueue(int len) {
    this.arr = new T[len];
  }

}
[_, _, _, _, _ ] size is 5

Queue<Integer> q = new ArrayQueue<Integer>(5);


