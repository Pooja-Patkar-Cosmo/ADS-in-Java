package LinkedList;

import java.util.Scanner;

class SinglyLinkedList<T> {
    static class Node<T> {
        T data; Node<T> next;
        Node(T data) { this.data = data; this.next = null; }
    }
    Node<T> head = null;

    void insertFirst(T data) {
        Node<T> newNode = new Node<>(data);
        newNode.next = head;
        head = newNode;
    }

    void insertLast(T data) {
        Node<T> newNode = new Node<>(data);
        if (head == null) { head = newNode; return; }

        Node<T> temp = head;
        while (temp.next != null)
            temp = temp.next;
        temp.next = newNode;
    }

    void insertAtPosition(T data, int position) {
        if (position <= 1) { insertFirst(data); return; }

        Node<T> temp = head;

        for (int i = 1;  i < position - 1 && temp != null; i++)
            temp = temp.next;

        if (temp == null) { System.out.println("Invalid position"); return; }

        Node<T> newNode = new Node<>(data);
        newNode.next = temp.next;
        temp.next = newNode;
    }

    void deleteFirst() {
        if (head == null) { System.out.println("List is empty"); return; }
        head = head.next;
    }

    void deleteLast() {
        if (head == null || head.next == null) { head = null; return; }

        Node<T> temp = head;
        while (temp.next.next != null)
            temp = temp.next;

        temp.next = null;
    }

    void deleteAtPosition(int position) {
        if (head == null) { System.out.println("List is empty"); return; }
        if (position == 1) { head = head.next; return; }

        Node<T> temp = head;
        for (int i = 1; temp != null && i < position - 1; i++)
            temp = temp.next;
        if (temp == null || temp.next == null) { System.out.println("Invalid position"); return; }

        temp.next = temp.next.next;
    }

    void reverse() {
        Node<T> prev = null, current = head;
        while (current != null) {
            Node<T> temp = current.next;

            current.next = prev;

            prev = current;

            current = temp; }

        head = prev;
    }

    void display() {
        if (head == null) { System.out.println("List is empty"); return; }

        for (Node<T> temp = head; temp != null; temp = temp.next)
            System.out.print(temp.data + " -> ");

        System.out.println("NULL");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        int choice;
        do {
            System.out.println("---------------------------------------\n        SINGLY LINKED LIST\n---------------------------------------");
            System.out.println("1. Insert at First\n2. Insert at Last\n3. Insert at Position\n4. Delete from First\n5. Delete from Last\n6. Delete from Position\n7. Display\n8. Reverse\n9. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            switch (choice) {
                case 1 -> { System.out.print("Enter data: "); list.insertFirst(sc.nextInt()); }
                case 2 -> { System.out.print("Enter data: "); list.insertLast(sc.nextInt()); }
                case 3 -> { System.out.print("Enter data: "); int data = sc.nextInt(); System.out.print("Enter position: "); list.insertAtPosition(data, sc.nextInt()); }
                case 4 -> list.deleteFirst();
                case 5 -> list.deleteLast();
                case 6 -> { System.out.print("Enter position: "); list.deleteAtPosition(sc.nextInt()); }
                case 7 -> list.display();
                case 8 -> list.reverse();
                case 9 -> System.out.println("Exiting...");
                default -> System.out.println("Invalid choice!");
            }
        } while (choice != 9);
        sc.close();
    }
}