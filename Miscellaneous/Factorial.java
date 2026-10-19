import java.util.Scanner;

public class Factorial {
    static int count = 0;

    static long factorial(int n) {
        count++;
        return (n <= 1) ? 1 : n * factorial(n - 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter n (>= 0): ");
        int n = sc.nextInt();

        if (n < 0) {
            System.out.println("Invalid input! Must be >= 0.");
        } else {
            System.out.println(n + "! = " + factorial(n));
            System.out.println("Recursive calls (iterations): " + count);
        }
        sc.close();
    }
}