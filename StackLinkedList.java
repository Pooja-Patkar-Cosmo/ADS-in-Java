package stack;

import java.util.Scanner;

class StackLinkedList {
    static class Node { int data; Node next; Node(int data) { this.data = data; } }
    Node top = null;
    int size = 0;

    void push(int data) {
        Node newNode = new Node(data);
        newNode.next = top; top = newNode; size++;
        System.out.println(data + " pushed into stack");
    }

    void pop() {
        if (top == null) { System.out.println("Stack Underflow"); return; }
        System.out.println(top.data + " popped from stack");
        top = top.next; size--;
    }
    void peek() { System.out.println(top == null ? "Stack is empty" : "Top element: " + top.data); }
    void display() {
        if (top == null) { System.out.println("Stack is empty"); return; }
        System.out.println("----- Stack -----");
        for (Node t = top; t != null; t = t.next) System.out.println(t.data);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StackLinkedList s = new StackLinkedList();
        int ch;
        do {
            System.out.println("1. Push");
            System.out.println("2. Pop");
            System.out.println("3. Peek");
            System.out.println("4. Is Empty");
            System.out.println("5. Size");
            System.out.println("6. Display");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            ch = sc.nextInt();
            switch (ch) {
                case 1 -> { System.out.print("Enter data: "); s.push(sc.nextInt()); }
                case 2 -> s.pop();
                case 3 -> s.peek();
                case 4 -> System.out.println(s.top == null ? "Stack is empty" : "Stack is not empty");
                case 5 -> System.out.println("Stack size: " + s.size);
                case 6 -> s.display();
                case 7 -> System.out.println("Exiting...");
                default -> System.out.println("Invalid choice!");
            }
        } while (ch != 7);
        sc.close();
    }
}