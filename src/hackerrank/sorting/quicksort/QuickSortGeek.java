package hackerrank.sorting.quicksort;

// Java program for implementation of QuickSort
public class QuickSortGeek {
	public static int count = 0;

	public static void sort(int arr[], int low, int high) {
		int pos = 0;
		
		if (low < high) {
			// Geeks
			pos = partLeftOnly(arr, low, high);
			sort(arr, low, pos-1);
			sort(arr, pos+1, high);
		}
	}
	
	private static int partLeftOnly(int arr[], int low, int high) {
        int pivot = arr[high]; 
        int pos = low;
        int i = 0;
        
        // first find out the initial partitioning position to start with
        for (i = low; i < high; i++) {
        	 // stop at the first bigger than the pivot value
        	if (arr[i] > pivot) {
        		pos = i;
        		break;
        	}
        }
        
        if (i == high) {
        	// there is no other bigger value
            return high;
        }
        
        for (i = pos + 1; i < high; i++) {
            if (arr[i] < pivot) {
                // smaller than the pivot, go to the left side of pos
                swap(arr, pos, i);
            	pos++;  // shift the boundary to the right
            }
        }
 
        // Finally place the pivot to its correct position, otherwise it is at its right
        // position already
        if (pos < high) {
            swap(arr, pos, high);
        }
        
        return pos;
    }

	private static void swap(int arr[], int x, int y) {
		if (x != y) {
			int temp = arr[x];
			arr[x] = arr[y];
			arr[y] = temp;

			count++;
		}
	}
}

