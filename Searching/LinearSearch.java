package searching;

import java.util.Scanner;

public class LinearSearch {

    static int comparisons;

    public static int linearSearch(int[] arr, int target) {
        comparisons = 0;
        for (int i = 0; i < arr.length; i++) {
            comparisons++;
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] a = { 10, 25, 30, 45, 50, 65, 70, 85, 90 };
        int n = a.length;

        // User input search
        System.out.print("Enter target element to search: ");
        int target = sc.nextInt();
        int userIndex = linearSearch(a, target);

        if (userIndex != -1) {
            System.out.println("User target found at index  : " + userIndex);
        } else {
            System.out.println("User target not found in array");
        }
        System.out.println("Comparisons for user target  : " + comparisons + " comparison(s)\n");


        // Best case: Element at index 0
        linearSearch(a, a[0]);
        System.out.println("Best case        (key at index 0)   : " + comparisons + " comparison(s)");

        // Middle case: Element at index n / 2
        linearSearch(a, a[n / 2]);
        System.out.println("Middle           (key at index n/2) : " + comparisons + " comparison(s)");

        // Worst case (present): Element at index n - 1
        linearSearch(a, a[n - 1]);
        System.out.println("Worst case       (key at the end)   : " + comparisons + " comparison(s)");

        // Worst case (absent): Key not present in the array
        linearSearch(a, -7);
        System.out.println("Worst case       (key not present)  : " + comparisons + " comparison(s)");

        // Average case: Average over every valid position
        long total = 0;
        for (int i = 0; i < n; i++) {
            linearSearch(a, a[i]);
            total += comparisons;
        }
        System.out.println("Average (key present, uniform)      : " + ((double) total / n) + " (~ n/2 -> still O(n))");


        sc.close();
    }
}