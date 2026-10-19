package queue;



import java.util.Scanner;

class QueueLinkedList {

    // Encapsulated static inner class for Node
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Queue fields
    Node front;
    Node rear;
    int count;

    // Constructor
    QueueLinkedList() {
        front = null;
        rear = null;
        count = 0;
    }

    // Enqueue: Adds an element to the rear
    void enqueue(int data) {
        Node newNode = new Node(data);

        if (isEmpty()) {
            front = newNode;
            rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }

        count++;
        System.out.println(data + " inserted into queue");
    }

    // Dequeue: Removes an element from the front
    void dequeue() {
        if (isEmpty()) {
            System.out.println("Queue Underflow");
            return;
        }

        System.out.println(front.data + " deleted from queue");
        front = front.next;

        // If queue becomes empty after dequeue
        if (front == null) {
            rear = null;
        }

        count--;
    }

    // Peek: Views the front element
    void peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }

        System.out.println("Front element: " + front.data);
    }

    // Is Empty
    boolean isEmpty() {
        return front == null;
    }

    // Get Size
    int getSize() {
        return count;
    }

    // Display
    void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }

        System.out.println("Queue:");
        Node temp = front;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    // Main method
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        QueueLinkedList queue = new QueueLinkedList();

        int choice;

        do {
            System.out.println("\n===== QUEUE (LINKED LIST) =====");
            System.out.println("1. Enqueue");
            System.out.println("2. Dequeue");
            System.out.println("3. Peek");
            System.out.println("4. Is Empty");
            System.out.println("5. Size");
            System.out.println("6. Display");
            System.out.println("7. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter data: ");
                    int data = sc.nextInt();
                    queue.enqueue(data);
                    break;

                case 2:
                    queue.dequeue();
                    break;

                case 3:
                    queue.peek();
                    break;

                case 4:
                    if (queue.isEmpty()) {
                        System.out.println("Queue is empty");
                    } else {
                        System.out.println("Queue is not empty");
                    }
                    break;

                case 5:
                    System.out.println("Queue size: " + queue.getSize());
                    break;

                case 6:
                    queue.display();
                    break;

                case 7:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 7);

        sc.close();
    }
}







