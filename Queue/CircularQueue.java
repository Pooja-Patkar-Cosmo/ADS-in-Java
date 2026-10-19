package queue;

import java.util.Scanner;

public class CircularQueue {
    private int[] q;
    private int front;
    private int rear;
    private int count;
    private int size;

    // Constructor assigning parameter capacity directly to field size
    public CircularQueue(int capacity) {
        size = capacity;
        q = new int[size];

        front = -1; rear = -1; count = 0;
    }

    public void enqueue(int data) {
        if (isFull()) { System.out.println("Queue is Full!"); return; }
        if (front == -1) front = 0;

        rear = (rear + 1) % size;
        q[rear] = data;
        count++;
        System.out.println("Enqueued: " + data);
    }

    public void dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is Empty!");
            return;
        }
        System.out.println("Dequeued: " + q[front]);
        front = (front + 1) % size;
        count--;
        if (count == 0) front = rear = -1;
    }

    public void peek() {
        if (isEmpty()) {
            System.out.println("Queue is Empty!");
        } else {
            System.out.println("Front element: " + q[front]);
        }
    }

    public boolean isEmpty() { return count == 0; }
    public boolean isFull() { return count == size; }
    public int getSize() { return count; }

    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is Empty!");
            return;
        }
        System.out.print("Queue elements: ");
        for (int i = 0; i < count; i++) {
            System.out.print(q[(front + i) % size] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter capacity of the queue: ");
        CircularQueue cq = new CircularQueue(sc.nextInt());

        int ch;
        do {
            System.out.println("\n1. Enqueue\n2. Dequeue\n3. Peek\n4. Is Empty\n5. Is Full\n6. Size (Count)\n7. Display\n8. Exit");
            System.out.print("Enter choice: ");
            ch = sc.nextInt();
            switch (ch) {
                case 1 -> { System.out.print("Enter value: "); cq.enqueue(sc.nextInt());}
                case 2 -> cq.dequeue();
                case 3 -> cq.peek();
                case 4 -> System.out.println("Is Empty: " + cq.isEmpty());
                case 5 -> System.out.println("Is Full: " + cq.isFull());
                case 6 -> System.out.println("Size: " + cq.getSize());
                case 7 -> cq.display();
                case 8 -> System.out.println("Exiting...");
                default -> System.out.println("Invalid choice!");
            }
        } while (ch != 8);

        sc.close();
    }
}