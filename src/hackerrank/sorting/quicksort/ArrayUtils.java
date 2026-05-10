package hackerrank.sorting.quicksort;

import java.util.Random;

public class ArrayUtils {
	
	public static double log(int x, int base) {
	    return Math.log(x) / Math.log(base);
	}
	
	// Generate count random numbers in the range of start to end
	public static int[] generateNumbers(int start, int end, int count) {
		int array[] = new int[count];
		int num;
		double factor;
		Random random = new Random();
		
		for (int i = 0; i < count; i++) {
			factor = random.nextDouble();
			num = (int)((end - start) * factor) + start;
			array[i] = num;
		}
		
		return array;
	}
	
	public static void printArray(int arr[]) {
		System.out.print("[" + arr.length +"]: {");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println("}");
	}
	
	public static int compareArrays(int[] arr1, int[] arr2) {
		for (int i = 0; i < arr1.length; i++) {
			if (arr1[i] != arr2[i]) {
				return (i+1);
			}
		}
		return 0;
	}
}
