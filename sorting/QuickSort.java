package sorting;

public class QuickSort {

    static int comparisons = 0;

    public static void sort(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);
            sort(arr, low, pivotIndex - 1);
            sort(arr, pivotIndex + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            comparisons++;
            if (arr[j] <= pivot) {
                i++;
                swap(arr, i, j);
            }
        }

        swap(arr, i + 1, high);
        return i + 1;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = { 38, 27, 43, 3, 9, 82, 10 };

        sort(arr, 0, arr.length - 1);

        System.out.print("Sorted array: ");
        for (int val : arr) {
            System.out.print(val + " ");
        }
        System.out.println();
        System.out.println("Total comparisons: " + comparisons);
    }
}