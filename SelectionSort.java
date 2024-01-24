import java.util.Random;

public class SelectionSort {
    void sort(int[] arr)
    {
        int n = arr.length;

        // One by one move boundary of unsorted subarray
        for (int i = 0; i < n-1; i++)
        {
            // Find the minimum element in unsorted array
            int min_idx = i;
            for (int j = i+1; j < n; j++)
                if (arr[j] < arr[min_idx])
                    min_idx = j;

            // Swap the found minimum element with the first
            // element
            int temp = arr[min_idx];
            arr[min_idx] = arr[i];
            arr[i] = temp;
        }
    }

    // Prints the array
    void printArray(int[] arr)
    {
        int n = arr.length;
        for (int j : arr)
            System.out.print(j + " ");
        System.out.println();
    }

    // Driver code to test above
    public static void main(String[] args)
    {
        SelectionSort ob = new SelectionSort();
        Random rand = new Random();
        int n = 200;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = rand.nextInt(1000);
        }
        System.out.println("Unsorted array");
        ob.printArray(arr);
        int time_start = (int)System.currentTimeMillis();
        ob.sort(arr);
        int time_end = (int)System.currentTimeMillis();
        System.out.println("Sorted array");
        ob.printArray(arr);
        System.out.println("Time taken: " + (time_end - time_start) + "ms");
    }
}
