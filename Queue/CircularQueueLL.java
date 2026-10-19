package queue;

import java.util.Scanner;

public class CircularQueueLL {
    static class Node {
        int data;
        Node next;
        Node(int val) { this.data = val; }
    }

    static Node rear = null;
    static int count = 0;

    static boolean isEmpty() { return rear == null; }
    static boolean isFull()  { return false; } // Linked list is dynamic
    static int size()        { return count; }

    static void enqueue(int val) {
        Node newNode = new Node(val);
        if (isEmpty()) {
            newNode.next = newNode;
            rear = newNode;
        } else {
            newNode.next = rear.next;
            rear.next = newNode;
            rear = newNode;
        }
        count++;
        System.out.println("Enqueued: " + val);
    }

    static void dequeue() {
        if (isEmpty()) { System.out.println("Queue is Empty!"); return; }
        int val = rear.next.data;
        if (rear.next == rear) rear = null;
        else rear.next = rear.next.next;
        count--;
        System.out.println("Dequeued: " + val);
    }

    static void peek() {
        if (isEmpty()) System.out.println("Queue is Empty!");
        else System.out.println("Front element: " + rear.next.data);
    }

    static void display() {
        if (isEmpty()) { System.out.println("Queue is Empty!"); return; }
        System.out.print("Queue elements: ");
        Node temp = rear.next;
        do {
            System.out.print(temp.data + " ");
            temp = temp.next;
        } while (temp != rear.next);
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int ch;
        do {
            System.out.println("\n1. Enqueue\n2. Dequeue\n3. Peek\n4. Is Empty\n5. Is Full\n6. Size\n7. Display\n8. Exit");
            System.out.print("Enter choice: ");
            ch = sc.nextInt();
            switch (ch) {
                case 1 -> { System.out.print("Enter value: "); enqueue(sc.nextInt()); }
                case 2 -> dequeue();
                case 3 -> peek();
                case 4 -> System.out.println("Is Empty: " + isEmpty());
                case 5 -> System.out.println("Is Full: " + isFull());
                case 6 -> System.out.println("Size: " + size());
                case 7 -> display();
                case 8 -> System.out.println("Exiting...");
                default -> System.out.println("Invalid choice!");
            }
        } while (ch != 8);
        sc.close();
    }
}