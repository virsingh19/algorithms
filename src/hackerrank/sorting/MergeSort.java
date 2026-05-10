package hackerrank.sorting;

/**
 * Merge Sort Implementation in Java
 * Time Complexity: O(n log n) in all cases (best, average, worst)
 * Space Complexity: O(n) for the auxiliary arrays
 * Stable Sort: Yes (preserves relative order of equal elements)
 * In-place: No (requires extra space)
 */
public class MergeSort {
    /**
     * Main merge sort method (wrapper)
     * @param arr Array to sort
     */
    public static void sort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        mergeSort(arr, 0, arr.length - 1);
    }

    /**
     * Recursive merge sort implementation
     * Divides array into two halves, recursively sorts them, then merges
     *
     * @param arr Array to sort
     * @param left Left index
     * @param right Right index
     */
    private static void mergeSort(int[] arr, int left, int right) {
        // Base case: array of size 1 is already sorted
        if (left >= right) {
            return;
        }

        // Divide the array into two, find middle index to divide array
        int mid = left + (right - left) / 2;

        // Recursively sort left half: [left, mid]
        mergeSort(arr, left, mid);

        // Recursively sort right half: [mid+1, right]
        mergeSort(arr, mid + 1, right);

        // Merge the sorted halves
        merge(arr, left, mid, right);
    }

    /**
     * Merge two sorted subarrays into one sorted array
     * Left subarray: arr[left...mid]
     * Right subarray: arr[mid+1...right]
     *
     * @param arr Array containing both subarrays
     * @param left Start index of left subarray
     * @param mid End index of left subarray
     * @param right End index of right subarray
     */
    private static void merge(int[] arr, int left, int mid, int right) {
        // Create temporary arrays for left and right subarrays
        int[] leftArr = new int[mid - left + 1]; // mid element belongs to the left subarray
        int[] rightArr = new int[right - mid];

        // System.arraycopy(sourceArray, srcPos, destArray, destPos, numElements);
        System.arraycopy(arr, 0, leftArr, 0, leftArr.length);

        for (int i = 0; i < rightArr.length; i++) {
            rightArr[i] = arr[mid + 1 + i];
        }

        // Merge the temporary arrays back into arr[left...right]
        int i = 0;      // Index for left subarray
        int j = 0;      // Index for right subarray
        int k = left;   // Index for merged array

        // Compare elements from left and right, place smaller one in arr
        while (i < leftArr.length && j < rightArr.length) {
            if (leftArr[i] <= rightArr[j]) {
                arr[k++] = leftArr[i++];
            } else {
                arr[k++] = rightArr[j++];
            }
        }

        // Copy remaining elements from left subarray (if any)
        while (i < leftArr.length) {
            arr[k++] = leftArr[i++];
        }

        // Copy remaining elements from right subarray (if any)
        while (j < rightArr.length) {
            arr[k++] = rightArr[j++];
        }
    }

    /**
     * Print array for debugging and testing
     * @param arr Array to print
     */
    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) System.out.print(", ");
        }
        System.out.println();
    }

    /**
     * Verify if array is sorted in ascending order
     * @param arr Array to verify
     * @return true if sorted, false otherwise
     */
    public static boolean isSorted(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                return false;
            }
        }
        return true;
    }

    /**
     * Main: test merge sort with various inputs
     */
    public static void main(String[] args) {
        System.out.println("=".repeat(70));
        System.out.println("MERGE SORT IMPLEMENTATION");
        System.out.println("=".repeat(70));

        // Test 1: Random unsorted array
        System.out.println("\nTest 1: Random unsorted array");
        System.out.println("-".repeat(70));
        int[] arr1 = {38, 27, 43, 3, 9, 82, 10};
        System.out.print("Original: ");
        printArray(arr1);
        sort(arr1);
        System.out.print("Sorted:   ");
        printArray(arr1);
        System.out.println("Is sorted? " + isSorted(arr1));

        // Test 2: Already sorted array
        System.out.println("\nTest 2: Already sorted array");
        System.out.println("-".repeat(70));
        int[] arr2 = {1, 2, 3, 4, 5};
        System.out.print("Original: ");
        printArray(arr2);
        sort(arr2);
        System.out.print("Sorted:   ");
        printArray(arr2);
        System.out.println("Is sorted? " + isSorted(arr2));

        // Test 3: Reverse sorted array
        System.out.println("\nTest 3: Reverse sorted array");
        System.out.println("-".repeat(70));
        int[] arr3 = {5, 4, 3, 2, 1};
        System.out.print("Original: ");
        printArray(arr3);
        sort(arr3);
        System.out.print("Sorted:   ");
        printArray(arr3);
        System.out.println("Is sorted? " + isSorted(arr3));

        // Test 4: Array with duplicates
        System.out.println("\nTest 4: Array with duplicates");
        System.out.println("-".repeat(70));
        int[] arr4 = {5, 2, 8, 2, 9, 1, 5, 5};
        System.out.print("Original: ");
        printArray(arr4);
        sort(arr4);
        System.out.print("Sorted:   ");
        printArray(arr4);
        System.out.println("Is sorted? " + isSorted(arr4));

        // Test 5: Single element
        System.out.println("\nTest 5: Single element");
        System.out.println("-".repeat(70));
        int[] arr5 = {42};
        System.out.print("Original: ");
        printArray(arr5);
        sort(arr5);
        System.out.print("Sorted:   ");
        printArray(arr5);
        System.out.println("Is sorted? " + isSorted(arr5));

        // Test 6: Empty array
        System.out.println("\nTest 6: Empty array");
        System.out.println("-".repeat(70));
        int[] arr6 = {};
        System.out.print("Original: ");
        printArray(arr6);
        sort(arr6);
        System.out.print("Sorted:   ");
        printArray(arr6);
        System.out.println("Is sorted? " + isSorted(arr6));

        // Test 7: Large array
        System.out.println("\nTest 7: Large array (10,000 elements)");
        System.out.println("-".repeat(70));
        int[] arr7 = new int[10000];
        for (int i = 0; i < arr7.length; i++) {
            arr7[i] = (int) (Math.random() * 10000);
        }
        long startTime = System.nanoTime();
        sort(arr7);
        long endTime = System.nanoTime();
        long duration = (endTime - startTime) / 1_000_000;  // Convert to milliseconds
        System.out.println("Is sorted? " + isSorted(arr7));
        System.out.println("Time taken: " + duration + " ms");

        System.out.println("\n" + "=".repeat(70));
    }
}

