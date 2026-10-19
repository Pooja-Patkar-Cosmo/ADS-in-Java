package sorting;

import java.util.Scanner;
import java.util.Arrays;

public class InsertionSort {
    public static int insertionSort(int[] arr) {
        int n = arr.length;
        int shifts = 0;

        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;

            // Shift elements of arr[0..i-1] that are greater than key
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
                shifts++;
            }
            arr[j + 1] = key;
        }
        return shifts;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of elements: ");
        int n = sc.nextInt();

        int[] numbers = new int[n];
        System.out.println("Enter " + n + " elements: ");
        for (int i = 0; i < n; i++) {
            numbers[i] = sc.nextInt();
        }

        System.out.println("Original Array: " + Arrays.toString(numbers));

        int totalShifts = insertionSort(numbers);

        System.out.println("Sorted Array: " + Arrays.toString(numbers));
        System.out.println("Total shifts: " + totalShifts);

        sc.close();
    }
}