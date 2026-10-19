package searching;

import java.util.Scanner;

public class BinarySearch {

    static int shifts;

    public static int binarySearch(int[] arr, int target) {
        shifts = 0;
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (target == arr[mid]) {
                return mid;
            } else if (target < arr[mid]) {
                high = mid - 1;
                shifts++; // boundary shifted left
            } else {
                low = mid + 1;
                shifts++; // boundary shifted right
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] a = { 10, 25, 30, 45, 50, 65, 70, 85, 90 };

        System.out.print("Enter target element to search: ");
        int target = sc.nextInt();
        int userIndex = binarySearch(a, target);

        if (userIndex != -1) {
            System.out.println("User target found at index  : " + userIndex);
        } else {
            System.out.println("User target not found in array");
        }
        System.out.println("Total shifts made            : " + shifts + " shift(s)");

        sc.close();
    }
}



//      RECURSIVE APPROACH
/*
import java.util.Scanner;

public class BinarySearch {

    static int shifts = 0;

    public static int binarySearch(int[] arr, int target, int low, int high) {
        if (low > high) return -1;

        int mid = low + (high - low) / 2;

        if (target == arr[mid]) {
            return mid;
        } else if (target < arr[mid]) {
            shifts++;
            return binarySearch(arr, target, low, mid - 1);
        } else {
            shifts++;
            return binarySearch(arr, target, mid + 1, high);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] a = { 10, 25, 30, 45, 50, 65, 70, 85, 90 };

        System.out.print("Enter target element to search: ");
        int userTarget = sc.nextInt();
        int userIndex = binarySearch(a, userTarget, 0, a.length - 1);

        if (userIndex != -1) {
            System.out.println("User target found at index  : " + userIndex);
        } else {
            System.out.println("User target not found in array");
        }
        System.out.println("Total shifts made            : " + shifts + " shift(s)");

        sc.close();
    }
}
*/
