import java.util.Random;

public class QuickSort {

    static void sort(int[] nums, int low, int hi) {
        if (low >= hi) {
            return;
        }

        int s = low;
        int e = hi;
        int m = s + (e - s) / 2;
        int pivot = nums[m];

        while (s <= e) {

            // also a reason why if its already sorted it will not swap
            while (nums[s] < pivot) {
                s++;
            }
            while (nums[e] > pivot) {
                e--;
            }

            if (s <= e) {
                int temp = nums[s];
                nums[s] = nums[e];
                nums[e] = temp;
                s++;
                e--;
            }
        }

        // now my pivot is at correct index, please sort two halves now
        sort(nums, low, e);
        sort(nums, s, hi);
    }
    // Prints the array
    static void printArray(int[] arr) {
        int n = arr.length;
        for (int j : arr)
            System.out.print(j + " ");

        System.out.println();
    }
    // Driver code to test above
    public static void main(String[] args)
    {
        Random rand = new Random();
        int n = 300;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = rand.nextInt(1000);
        }
        System.out.println("Unsorted array");
        printArray(arr);
        int time_start = (int)System.currentTimeMillis();
        sort(arr, 0, n - 1);
        int time_end = (int)System.currentTimeMillis();
        System.out.println("Sorted array");
        printArray(arr);
        System.out.println("Time taken: " + (time_end - time_start) + "ms");
    }
}
