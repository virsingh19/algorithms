package hackerrank.sorting;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int[] data = {12, 11, 13, 5, 6};

        System.out.println("Original Array: " + Arrays.toString(data));

        insertionSort(data);

        System.out.println("Sorted Array:   " + Arrays.toString(data));
    }

    // Function to sort array using insertion sort
    public static void insertionSort(int[] arr) {
        // Start from the second element (index 1)
        // index is the starting point of the unsorted portion of the array
        for (int index = 1; index < arr.length; index++) {
            int key = arr[index];   // The current element to be inserted

            // if the key value is not in sorted order, we need to insert it in the sorted portion of the array
            // find the correct position for the key in the sorted portion of the array
            for (int i = 0; i < index; i++) {
                if (arr[i] > key) {
                    // this is the position where the key should be inserted
                    // first shift the values by one to the right
                    int count = index - i; // number of elements to shift
                    System.arraycopy(arr,i, arr, i+1, count);
                    arr[i] = key; // insert the key at its correct position
                    break;
                }
            }
        }
    }
}
