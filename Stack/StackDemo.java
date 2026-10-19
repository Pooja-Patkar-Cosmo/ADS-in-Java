package stack;

import java.util.Scanner;

class StackDemo {
    int[] stack;
    int top = -1, capacity;

    StackDemo(int n) { capacity = n; stack = new int[n]; }

    void push(int x) {
        if (top == capacity - 1) System.out.println("Stack Overflow");
        else {
            //top ++;
            //stack[top] = x;

            stack[++top] = x;
            System.out.println(x + " pushed into stack");
        }
    }

    void pop() {
        if (top == -1) System.out.println("Stack Underflow");
        else System.out.println(stack[top--] + " popped from stack");
    }

    void peek() {
        System.out.println(top == -1 ? "Stack is empty" : "Top element: " + stack[top]);
    }

    void display() {
        if (top == -1) { System.out.println("Stack is empty"); return; }

        System.out.println("----- Stack -----");
        for (int i = top; i >= 0; i--) System.out.println(stack[i]);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter stack size: ");
        StackDemo s = new StackDemo(sc.nextInt());
        int ch;

        do {
            System.out.println("\n--------------------------------------");
            System.out.println("                STACK");
            System.out.println("--------------------------------------");
            System.out.println("1. Push");
            System.out.println("2. Pop");
            System.out.println("3. Peek");
            System.out.println("4. Is Empty");
            System.out.println("5. Is Full");
            System.out.println("6. Size");
            System.out.println("7. Display");
            System.out.println("8. Exit");

            System.out.print("Enter your choice: ");
            ch = sc.nextInt();

            switch (ch) {
                case 1 -> { System.out.print("Enter data: "); s.push(sc.nextInt()); }
                case 2 -> s.pop();
                case 3 -> s.peek();
                case 4 -> System.out.println(s.top == -1 ? "Stack is empty" : "Stack is not empty");
                case 5 -> System.out.println(s.top == s.capacity - 1 ? "Stack is full" : "Stack is not full");
                case 6 -> System.out.println("Stack size: " + (s.top + 1));
                case 7 -> s.display();
                case 8 -> System.out.println("Exiting...");
                default -> System.out.println("Invalid choice!");
            }
        } while (ch != 8);
        sc.close();
    }
}


