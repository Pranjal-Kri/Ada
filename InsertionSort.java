import java.util.Random;

public class InsertionSort {
    /*Function to sort array using insertion sort*/
    static void sort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            int key = arr[i];
            int j = i - 1;
            // At each pass right side of the array is sorted
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }

    // Prints the array
    static void printArray(int[] arr) {
        int n = arr.length;
        for (int j : arr)
            System.out.print(j + " ");

        System.out.println();
    }

    public static void main(String[] args) {
        Random rand = new Random();
        int n = 200;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = rand.nextInt(1000);
        }
        System.out.println("Unsorted array");
        printArray(arr);
        int time_start = (int) System.currentTimeMillis();
        sort(arr);
        int time_end = (int) System.currentTimeMillis();
        System.out.println("Sorted array");
        printArray(arr);
        System.out.println("Time taken: " + (time_end - time_start) + "ms");
    }
}
