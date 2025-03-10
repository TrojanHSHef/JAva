class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class Queue {
    private Node front;
    private Node rear;
    private int size;

    public Queue() {
        this.front = null;
        this.rear = null;
        this.size = 0;
    }

    public void enqueue(int data) {
        Node newNode = new Node(data);
        if (rear == null) {
            front = rear = newNode;
            size++;
            return;
        }
        rear.next = newNode;
        rear = newNode;
        size++;
    }

    public int dequeue() {
        if (front == null) {
            throw new IllegalStateException("Пусто");
        }
        int data = front.data;
        front = front.next;
        if (front == null) {
            rear = null;
        }
        size--;
        return data;
    }

    public int peek() {
        if (front == null) {
            throw new IllegalStateException("Пусто");
        }
        return front.data;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }
}

public class Main {
    public static void main(String[] args) {
        Queue queue = new Queue();
        
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        
        try {
            System.out.println(queue.dequeue()); // 10
            System.out.println(queue.peek());    // 20
            System.out.println(queue.isEmpty()); // false
            System.out.println(queue.size());     // 2
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }
    }
}
