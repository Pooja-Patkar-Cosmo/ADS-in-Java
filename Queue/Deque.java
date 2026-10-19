package queue;

import java.util.Scanner;

public class Deque {
    static final int MAX = 5;
    static int[] arr = new int[MAX];
    static int front = -1, rear = -1, count = 0;

    static boolean isEmpty() { return count == 0; }
    static boolean isFull()  { return count == MAX; }
    static int size()        { return count; }

    static void insertFront(int val) {
        if (isFull()) { System.out.println("Deque is Full!"); return; }
        if (isEmpty()) front = rear = 0;
        else front = (front - 1 + MAX) % MAX;
        arr[front] = val; count++;
        System.out.println("Inserted at Front: " + val);
    }

    static void insertRear(int val) {
        if (isFull()) { System.out.println("Deque is Full!"); return; }
        if (isEmpty()) front = rear = 0;
        else rear = (rear + 1) % MAX;
        arr[rear] = val; count++;
        System.out.println("Inserted at Rear: " + val);
    }

    static void deleteFront() {
        if (isEmpty()) { System.out.println("Deque is Empty!"); return; }
        System.out.println("Deleted from Front: " + arr[front]);
        if (front == rear) front = rear = -1;
        else front = (front + 1) % MAX;
        count--;
    }

    static void deleteRear() {
        if (isEmpty()) { System.out.println("Deque is Empty!"); return; }
        System.out.println("Deleted from Rear: " + arr[rear]);
        if (front == rear) front = rear = -1;
        else rear = (rear - 1 + MAX) % MAX;
        count--;
    }

    static void getFront() {
        if (isEmpty()) System.out.println("Deque is Empty!");
        else System.out.println("Front element: " + arr[front]);
    }

    static void getRear() {
        if (isEmpty()) System.out.println("Deque is Empty!");
        else System.out.println("Rear element: " + arr[rear]);
    }

    static void display() {
        if (isEmpty()) { System.out.println("Deque is Empty!"); return; }
        System.out.print("Deque elements: ");
        for (int i = 0; i < count; i++) System.out.print(arr[(front + i) % MAX] + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int ch;
        do {
            System.out.println("\n===== DOUBLE ENDED QUEUE =====");
            System.out.println("1. Insert at Front\n2. Insert at Rear\n3. Delete from Front\n4. Delete from Rear");
            System.out.println("5. Get Front\n6. Get Rear\n7. Is Empty\n8. Is Full\n9. Size\n10. Display\n11. Exit");
            System.out.print("Enter choice: ");
            ch = sc.nextInt();
            switch (ch) {
                case 1 -> { System.out.print("Enter value: "); insertFront(sc.nextInt()); }
                case 2 -> { System.out.print("Enter value: "); insertRear(sc.nextInt()); }
                case 3 -> deleteFront();
                case 4 -> deleteRear();
                case 5 -> getFront();
                case 6 -> getRear();
                case 7 -> System.out.println("Is Empty: " + isEmpty());
                case 8 -> System.out.println("Is Full: " + isFull());
                case 9 -> System.out.println("Size: " + size());
                case 10 -> display();
                case 11 -> System.out.println("Exiting...");
                default -> System.out.println("Invalid choice!");
            }
        } while (ch != 11);
        sc.close();
    }
}
