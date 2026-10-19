package sorting;

public class SelectionSort {

    static int comparisons = 0;
    static int swaps = 0;

    public static void sort(int[] arr) {
        int n = arr.length;          // total elements

        for (int i = 0; i < n - 1; i++) {
            int min = i;    // current Index

            for (int j = i + 1; j < n; j++) { // j is searchIndex
                comparisons++;
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }

            if (min != i) {
                swap(arr, i, min);
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        swaps++;
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = { 40, 22, 84, 80, 2, 98, 20 };

        sort(arr);

        System.out.print("Sorted array: ");
        for (int val : arr) {
            System.out.print(val + " ");
        }
        System.out.println();
        System.out.println("Total comparisons: " + comparisons);
        System.out.println("Total swaps: " + swaps);
    }
}