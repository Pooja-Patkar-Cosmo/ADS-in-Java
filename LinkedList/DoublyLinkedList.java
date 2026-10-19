package LinkedList;

import java.util.Scanner;

public class DoublyLinkedList<T> {
    static class Node<T> {
        T data;
        Node<T> prev, next;
        Node(T data) { this.data = data; }
    }
    private Node<T> head, tail;

    public void insertFirst(T data) {
        Node<T> newNode = new Node<>(data);
        if (head == null) head = tail = newNode;
        else { newNode.next = head; head.prev = newNode; head = newNode; }
    }

    public void insertLast(T data) {
        Node<T> newNode = new Node<>(data);
        if (tail == null) head = tail = newNode;
        else { tail.next = newNode; newNode.prev = tail; tail = newNode; }
    }

    public void insertAtPos(T data, int position) {
        if (position <= 1 || head == null) { insertFirst(data); return; }
        Node<T> temp = head;
        for (int i = 1; i < position - 1 && temp.next != null; i++) temp = temp.next;
        if (temp == tail) { insertLast(data); return; }
        Node<T> newNode = new Node<>(data);
        newNode.next = temp.next; newNode.prev = temp;
        temp.next.prev = newNode; temp.next = newNode;
    }

    public void deleteFirst() {
        if (head == null) { System.out.println("List is empty!"); return; }
        if (head == tail) head = tail = null;
        else { head = head.next; head.prev = null; }
    }

    public void deleteLast() {
        if (tail == null) { System.out.println("List is empty!"); return; }
        if (head == tail) head = tail = null;
        else { tail = tail.prev; tail.next = null; }
    }

    public void deleteAtPos(int position) {
        if (head == null) { System.out.println("List is empty!"); return; }
        if (position == 1) { deleteFirst(); return; }
        Node<T> temp = head;
        for (int i = 1; i < position && temp != null; i++) temp = temp.next; // reaches actual node to delete
        if (temp == null) { System.out.println("Position out of bounds!"); return; }
        if (temp == tail) { deleteLast(); return; }
        temp.prev.next = temp.next; temp.next.prev = temp.prev;
    }

    public void displayForward() {
        if (head == null) { System.out.println("List is empty!"); return; }
        for (Node<T> temp = head; temp != null; temp = temp.next) System.out.print(temp.data + " ");
        System.out.println();
    }

    public void displayBackward() {
        if (tail == null) { System.out.println("List is empty!"); return; }
        for (Node<T> temp = tail; temp != null; temp = temp.prev) System.out.print(temp.data + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DoublyLinkedList<Integer> dll = new DoublyLinkedList<>();
        int choice;
        do {
            System.out.println("\n===== DOUBLY LINKED LIST =====");
            System.out.println("1. Insert at First\n2. Insert at Last\n3. Insert at Position");
            System.out.println("4. Delete from First\n5. Delete from Last\n6. Delete from Position");
            System.out.println("7. Display Forward\n8. Display Backward\n9. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            switch (choice) {
                case 1 -> { System.out.print("Value: "); dll.insertFirst(sc.nextInt()); }
                case 2 -> { System.out.print("Value: "); dll.insertLast(sc.nextInt()); }
                case 3 -> { System.out.print("Value & Pos: "); dll.insertAtPos(sc.nextInt(), sc.nextInt()); }
                case 4 -> dll.deleteFirst();
                case 5 -> dll.deleteLast();
                case 6 -> { System.out.print("Pos: "); dll.deleteAtPos(sc.nextInt()); }
                case 7 -> { System.out.print("Forward: "); dll.displayForward(); }
                case 8 -> { System.out.print("Backward: "); dll.displayBackward(); }
                case 9 -> System.out.println("Exiting...");
                default -> System.out.println("Invalid choice!");
            }
        } while (choice != 9);
        sc.close();
    }
}