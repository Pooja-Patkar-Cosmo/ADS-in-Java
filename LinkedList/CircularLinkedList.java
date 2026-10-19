package LinkedList;

import java.util.Scanner;

public class CircularLinkedList<T> {
    static class Node<T> {
        T data;
        Node<T> next;
        Node(T data) { this.data = data; }
    }
    private Node<T> head, tail;

    public void insertFirst(T data) {
        Node<T> newNode = new Node<>(data);
        if (head == null) { head = tail = newNode; newNode.next = head; }
        else { newNode.next = head; head = newNode; tail.next = head; }
    }

    public void insertLast(T data) {
        if (head == null) { insertFirst(data); return; }
        Node<T> newNode = new Node<>(data);
        tail.next = newNode; newNode.next = head; tail = newNode;
    }

    public void insertAtPos(T data, int position) {
        if (position <= 1 || head == null) { insertFirst(data); return; }
        Node<T> temp = head;
        for (int i = 1; i < position - 1 && temp != tail; i++) temp = temp.next;
        if (temp == tail) { insertLast(data); return; }
        Node<T> newNode = new Node<>(data);
        newNode.next = temp.next; temp.next = newNode;
    }

    public void deleteFirst() {
        if (head == null) { System.out.println("List is empty!"); return; }
        if (head == tail) head = tail = null;
        else { head = head.next; tail.next = head; }
    }

    public void deleteLast() {
        if (head == null) { System.out.println("List is empty!"); return; }
        if (head == tail) { head = tail = null; return; }
        Node<T> temp = head;
        while (temp.next != tail) temp = temp.next;
        temp.next = head; tail = temp;
    }

    public void deleteAtPos(int position) {
        if (head == null) { System.out.println("List is empty!"); return; }
        if (position == 1) { deleteFirst(); return; }
        Node<T> temp = head, prev = null;
        for (int i = 1; i < position; i++) {
            prev = temp; temp = temp.next;
            if (temp == head) { System.out.println("Position out of bounds!"); return; }
        }
        if (temp == tail) { deleteLast(); return; }
        prev.next = temp.next;
    }

    public void display() {
        if (head == null) { System.out.println("List is empty!"); return; }
        Node<T> temp = head;
        do {
            System.out.print(temp.data + " ");
            temp = temp.next;
        } while (temp != head);
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CircularLinkedList<Integer> cll = new CircularLinkedList<>();
        int choice;
        do {
            System.out.println("\n===== CIRCULAR LINKED LIST =====");
            System.out.println("1. Insert at First\n2. Insert at Last\n3. Insert at Position");
            System.out.println("4. Delete from First\n5. Delete from Last\n6. Delete from Position");
            System.out.println("7. Display\n8. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            switch (choice) {
                case 1 -> { System.out.print("Value: "); cll.insertFirst(sc.nextInt()); }
                case 2 -> { System.out.print("Value: "); cll.insertLast(sc.nextInt()); }
                case 3 -> { System.out.print("Value & Pos: "); cll.insertAtPos(sc.nextInt(), sc.nextInt()); }
                case 4 -> cll.deleteFirst();
                case 5 -> cll.deleteLast();
                case 6 -> {System.out.print("Pos: "); cll.deleteAtPos(sc.nextInt()); }
                case 7 -> { System.out.print("List: "); cll.display(); }
                case 8 -> System.out.println("Exiting...");
                default -> System.out.println("Invalid choice!");
            }
        } while (choice != 8);
        sc.close();
    }
}
