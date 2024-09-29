### Problem Statement: **Circular Array Queue**

Implement a **circular queue** using arrays with the following operations:

1. **enqueue(x)**: Add an element `x` to the end of the queue. If the queue is full, return an appropriate message.
2. **dequeue()**: Remove and return the front element of the queue. If the queue is empty, return an appropriate message.
3. **front()**: Return the front element of the queue without removing it. If the queue is empty, return an appropriate message.
4. **isEmpty()**: Check whether the queue is empty and return `true` if it is, otherwise return `false`.
5. **isFull()**: Check whether the queue is full and return `true` if it is, otherwise return `false`.

Your task is to implement this circular queue using arrays, ensuring that when the queue reaches the end of the array, it wraps around to the beginning.