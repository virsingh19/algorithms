package hackerrank.sorting.quicksort;

/*
 * Implementation of QuickSort
 * https://howtodoinjava.com/algorithm/quicksort-java-example/
 * The logic is to find out correct position of a selected element in the array
 * then array will be divided into two parts, apply it recursively till all the
 * divided arrays are sorted.
 * Let us pick the last element to start with, from the left side check if there is
 * some element which is greater, same way from right side if some element is smaller
 * then switch these two elements, and keep repeating till indexes from left and right
 * sides meet each other.
 */
public class QuickSortViren {
	public static int count = 0;

	// Driver program
	public static void main(String args[]) {
		// test with one array
		int[] data = {4,3,2,1};

		sort(data, 0, data.length-1);
		ArrayUtils.printArray(data);
		
		// test with multiple arrays
		int arr[][] = {
			{1,2,3,4,5},
			{4,3,2,1},
			{3, 2, 6, 5},
			{6,5,2,3},
			{5, 3, 25, 6, 10, 17, 1, 2, 18, 8},  // good
			{9, 7, 5, 11, 12, 2, 14, 3, 10, 6},			
			{
				25, 18, 17, 10, 8, 6, 5, 3, 2, 1,
				3, 2, 5, 10, 7, 8, 9, 1, 5,
				10, 80, 30, 90, 40, 50, 70,
				1, 2, 3, 5, 6, 8, 10, 17, 18, 25,
				25, 18, 17, 10, 8, 6, 5, 3, 2, 1
			}
		};

		for (int index = 0; index < arr.length; index++) {
			System.out.print("Input [" + arr[index].length+"]: ");
			ArrayUtils.printArray(arr[index]);
			sort(arr[index], 0, arr[index].length-1);
			System.out.print("Output: ");
			ArrayUtils.printArray(arr[index]);
			System.out.println("Count: " + count);
		}
	}
	
	private static void swap(int arr[], int x, int y) {
		// no need to do anything in following conditions
		if ((arr == null) || (arr.length <= x) || (arr.length <= y) || (x == y)) {
			return;
		}
		
		count++;
		int temp = arr[x];
		arr[x] = arr[y];
		arr[y] = temp;
	}
	
	// main method to start with, low and high are the indexes
	// for the first call low = 0, high = length - 1
	public static void sort(int arr[], int low, int high) {
		// Out of the total elements, low is the first and high is the last element
		// if there are more than 1 total elements, then process further
		if (high > low) {
			int pivotPos = findPosition(arr, low, high);
			sort(arr, low, pivotPos-1);
			sort(arr, pivotPos+1, high);
		}
	}
	
	private static int findPosition(int data[], int low, int high) {
		// there may be a situation where low and high are same
		if (low == high) {
			return low;
		}
		
		int pivotPos = high;
		final int pivotVal = data[pivotPos];
		int i = low, j = high - 1;
		boolean foundLeft = false, foundRight = false;
		
		while (i < j) {
			// i moves to right to find a bigger number and j moves to left to find
			// a smaller number to swap
			if (!foundLeft) {
				if (data[i] > pivotVal) {
					foundLeft = true;
				} else {
					i++;
				}
			}

			if (!foundRight && j > i) {
				if (data[j] < pivotVal) {
					foundRight = true;
				} else {
					j--;
				}
			}

			// Have we found a swap
			if (foundLeft && foundRight) {
				swap(data, i, j);
				
				if ((j - i) > 1) {
					// reset for the next swap
					foundLeft = foundRight = false;
					i++;
			        j--;
				} else {
					// last was a swap where i and j will be one value apart (i+1 = j)
					break;
				}
			}
		}

		//System.out.println("  #### Counter check: i=" + i +", j=" + j);
		
		// Once the loop is done, we need to check for the last element
		if (foundLeft && foundRight) {
			swap(data, i+1, pivotPos);
			pivotPos = i+1;
		} else if (!foundLeft && !foundRight) {
			// If data[i] is less than or equal to pivot than swap with i+1 element
			if (data[i] <= pivotVal) {
				i++;
			}
			// Swap these two and i becomes the pivotPos
			swap(data, i, pivotPos);
			pivotPos = i;
		} else if (foundLeft) {
			// element at i index is bigger
			swap(data, i, pivotPos);
			pivotPos = i;
		} else if (foundRight) {
			// j element is smaller, but j+1 is bigger, replace it with j+1
			swap(data, j + 1, pivotPos);
			pivotPos = j + 1;
		}
        
		return pivotPos;
	}
}
