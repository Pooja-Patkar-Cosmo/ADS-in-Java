package sorting;

public class MergeSort {

    public static void sort(int[] arr, int[] temp, int low, int high) {
        if (low >= high) return;

        int mid = low + (high - low) / 2;
        sort(arr, temp, low, mid);
        sort(arr, temp, mid + 1, high);
        merge(arr, temp, low, mid, high);
    }

    private static void merge(int[] arr, int[] temp, int low, int mid, int high) {
        int i = low, j = mid + 1, k = low;

        while (i <= mid && j <= high) {
            temp[k++] = (arr[i] <= arr[j]) ? arr[i++] : arr[j++];
        }
        while (i <= mid)  temp[k++] = arr[i++];
        while (j <= high) temp[k++] = arr[j++];

        for (k = low; k <= high; k++) {
            arr[k] = temp[k];
        }
    }

    public static void main(String[] args) {
        int[] arr = { 38, 27, 43, 3, 9, 82, 10 };
        int[] temp = new int[arr.length];

        sort(arr, temp, 0, arr.length - 1);

        for (int val : arr) {
            System.out.print(val + " ");
        }
        System.out.println();
    }
}