import java.util.Scanner;

public class Fibonacci {
    static int count = 0;

    static void fib(int n, long a, long b) {
        count++;
        if (n < 0) return;

        System.out.print(a + "  ");
        fib(n-1, b, a+b);

    //This is an accumulator pattern - tail recursion  -> O(n) time.
    // Instead of computing backwards by branching into two calls like traditional recursion (fib(n-1) + fib(n-2)) which is slow O(2^n), 
  
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter n (>= 0): ");
        int n = sc.nextInt();

        if (n < 0) {
            System.out.println("Invalid input! Must be >= 0.");
        } else {
            System.out.println("Fibonacci Series : "); 
            fib(n, 0, 1);
            System.out.println("\nRecursive calls (iterations): " + count);
        }
        sc.close();
    }
}