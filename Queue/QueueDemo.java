package queue;

import java.util.Scanner;

public class QueueDemo {
    int size, front = -1, rear = -1, queue[];

    public QueueDemo(int capacity) {
        size = capacity;
        queue = new int[size];
    }

    boolean isEmpty() { return front == -1 || front > rear; }
    boolean isFull()  { return rear == size - 1; }
    int getCurrentSize() { return isEmpty() ? 0 : rear - front + 1; }

    void enqueue(int data) {
        if (isFull()) { System.out.println("Queue is Full!"); return; }
        if (front == -1) front = 0;
        queue[++rear] = data;
        System.out.println("Enqueued: " + data);
    }

    void dequeue() {
        if (isEmpty()) { System.out.println("Queue is Empty!"); return; }
        System.out.println("Dequeued: " + queue[front++]);
        if (front > rear) front = rear = -1;
    }

    void peek() {
        if (isEmpty()) System.out.println("Queue is Empty!");
        else System.out.println("Front element: " + queue[front]);
    }

    void display() {
        if (isEmpty()) { System.out.println("Queue is Empty!"); return; }
        System.out.print("Queue elements: ");
        for (int i = front; i <= rear; i++) System.out.print(queue[i] + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter capacity of the queue: ");
        QueueDemo q = new QueueDemo(sc.nextInt());
        int ch;
        do {
            System.out.print("\n1.Enqueue 2.Dequeue 3.Peek 4.IsEmpty 5.IsFull 6.Size 7.Display 8.Exit\nEnter choice: ");
            ch = sc.nextInt();
            switch (ch) {
                case 1 -> { System.out.print("Enter value: "); q.enqueue(sc.nextInt()); }
                case 2 -> q.dequeue();
                case 3 -> q.peek();
                case 4 -> System.out.println("Is Empty: " + q.isEmpty());
                case 5 -> System.out.println("Is Full: " + q.isFull());
                case 6 -> System.out.println("Size: " + q.getCurrentSize());
                case 7 -> q.display();
                case 8 -> System.out.println("Exiting...");
                default -> System.out.println("Invalid choice!");
            }
        } while (ch != 8);
        sc.close();
    }
}