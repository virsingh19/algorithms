package hackerrank.sorting.quicksort;


public class Caller {
	// Driver program
	public static void main(String args[]) {
        int arr1[] = null;
        int arr2[] = null;

		for (int index = 1; index <= 5; index++) {
			int start = 10;
			int end = index*100;
			int count = index*100;
			int avgComp = (int)(count*ArrayUtils.log(count, 2));
			
			// arr1 and arr2 both are having same data sets
			arr1 = ArrayUtils.generateNumbers(start, end, count);
			arr2 = arr1.clone();
			
			// Geeks algo
			System.out.print("Input => ");
			ArrayUtils.printArray(arr1);
			QuickSortGeek.count = 0;
			QuickSortGeek.sort(arr1, 0, arr1.length-1);
			
			System.out.print("Output Geeks => ");
			ArrayUtils.printArray(arr1);
			
			// Viren algo
			QuickSortViren.count = 0;
			QuickSortViren.sort(arr2, 0, arr2.length-1);
			System.out.print("Output Viren => ");
			ArrayUtils.printArray(arr2);
			
			System.out.println("### Geeks count: " + QuickSortGeek.count + ", Avg Complexity: " + avgComp);
			System.out.println("### Viren count: " + QuickSortViren.count + ", Avg Complexity: " + avgComp);
			
			int status = ArrayUtils.compareArrays(arr1, arr2);
			if (status > 0) {
			    System.out.println("### Mismatch in output: " + status);
			}
		}
	}
}
