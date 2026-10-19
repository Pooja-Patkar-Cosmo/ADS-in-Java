package sorting;

import java.util.Scanner;

public class BubbleSort {
    public static int bubbleSort(int[] arr) {
        int n = arr.length;
        int swapCount = 0;
        boolean swapped;

        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Swap elements
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;

                    swapCount++;
                    swapped = true;
                }
            }
            if (!swapped) break;
        }

        return swapCount;
    }

    // Helper method to print primitive array without Arrays.toString()
    public static void printArray(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        int[] numbers = new int[n];
        System.out.println("Enter " + n + " integers:");
        for (int i = 0; i < n; i++) {
            numbers[i] = sc.nextInt();
        }

        System.out.print("\nOriginal Array: ");
        printArray(numbers);

        int totalSwaps = bubbleSort(numbers);

        System.out.print("Sorted Array:   ");
        printArray(numbers);
        System.out.println("Total Swaps:    " + totalSwaps);

        sc.close();
    }
}