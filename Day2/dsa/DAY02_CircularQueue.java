import java.util.NoSuchElementException;

public class DAY02_CircularQueue<T> {
    private Object[] data;
    private int front, rear, size, capacity;

    public DAY02_CircularQueue() { this(4); }

    public DAY02_CircularQueue(int initialCapacity) {
        capacity = Math.max(2, initialCapacity);
        data = new Object[capacity];
        front = 0; rear = 0; size = 0;
    }

    public int size() { return size; }
    public boolean isEmpty() { return size == 0; }

    // Enqueue with dynamic resize
    public void enqueue(T item) {
        if (size == capacity) expand();
        data[rear] = item;
        rear = (rear + 1) % capacity;
        size++;
    }

    @SuppressWarnings("unchecked")
    public T dequeue() {
        if (isEmpty()) throw new NoSuchElementException("Queue is empty");
        T item = (T) data[front];
        data[front] = null;
        front = (front + 1) % capacity;
        size--;
        if (size > 0 && size == capacity/4) shrink();
        return item;
    }

    @SuppressWarnings("unchecked")
    public T peek() {
        if (isEmpty()) throw new NoSuchElementException("Queue is empty");
        return (T) data[front];
    }

    private void expand() {
        int newCap = capacity * 2;
        Object[] arr = new Object[newCap];
        for (int i = 0; i < size; i++) arr[i] = data[(front + i) % capacity];
        data = arr;
        capacity = newCap;
        front = 0; rear = size;
    }

    private void shrink() {
        int newCap = Math.max(4, capacity / 2);
        Object[] arr = new Object[newCap];
        for (int i = 0; i < size; i++) arr[i] = data[(front + i) % capacity];
        data = arr;
        capacity = newCap;
        front = 0; rear = size;
    }

    // Simple demo main
    public static void main(String[] args) {
        DAY02_CircularQueue<Integer> q = new DAY02_CircularQueue<>(2);
        q.enqueue(10); q.enqueue(20);
        q.enqueue(30); q.enqueue(40);
        System.out.println("Dequeued: " + q.dequeue());
        q.enqueue(50);
        while (!q.isEmpty()) System.out.println("Dequeue: " + q.dequeue());
    }
}