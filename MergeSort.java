import java.util.Random;

public class MergeSort {
    static void mergeSortInPlace(int[] arr, int s, int e) {
        if (e - s == 1) {
            return;
        }

        int mid = (s + e) / 2;

        mergeSortInPlace(arr, s, mid);
        mergeSortInPlace(arr, mid, e);

        mergeInPlace(arr, s, mid, e);
    }

    private static void mergeInPlace(int[] arr, int s, int m, int e) {
        int[] mix = new int[e - s];

        int i = s;
        int j = m;
        int k = 0;

        while (i < m && j < e) {
            if (arr[i] < arr[j]) {
                mix[k] = arr[i];
                i++;
            } else {
                mix[k] = arr[j];
                j++;
            }
            k++;
        }

        // it may be possible that one of the arrays is not complete
        // copy the remaining elements
        while (i < m) {
            mix[k] = arr[i];
            i++;
            k++;
        }

        while (j < e) {
            mix[k] = arr[j];
            j++;
            k++;
        }

        for (int l = 0; l < mix.length; l++) {
            arr[s+l] = mix[l];
        }
    }
    // Prints the array
    static void printArray(int[] arr) {
        int n = arr.length;
        for (int j : arr)
            System.out.print(j + " ");

        System.out.println();
    }

    public static void main(String[] args)
    {
        Random rand = new Random();
        int n = 2;
        // int[] arr = new int[1];
        // for (int i = 0; i < n; i++) {
        //     arr[i] = rand.nextInt(1000);
        // }
        int[] arr = { 12,11};
        System.out.println("Unsorted array");
        printArray(arr);
        int time_start = (int)System.currentTimeMillis();
        mergeSortInPlace(arr, 0, n);
        int time_end = (int)System.currentTimeMillis();
        System.out.println("Sorted array");
        printArray(arr);
        System.out.println("Time taken: " + (time_end - time_start) + "ms");
    }
}
