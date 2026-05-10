package utils;

import java.util.List;
import java.util.Random;

public class CommonUtils {
	public static void printList(List<Integer> list) {
		if (list != null) {
            for (Integer integer : list) {
                System.out.print(integer + " ");
            }
			System.out.println();
		}
	}
	
	public static void printArray(int[] data) {
        for (int datum : data) {
            System.out.print(datum + " ");
        }
		System.out.println();
	}

	// Return a random integer between "from" and "to" (inclusive)
	public static int getRandomInt(int from, int to) {
		Random random = new Random();
		int min = Math.min(from, to);
		int max = Math.max(from, to);
		return random.nextInt(max - min + 1) + min;
	}

	// Shift elements to the right by 1 at "pos" for "count" elements in the same array
	public static void shiftRight(int[] arr, int pos, int count) {
        System.arraycopy(arr, pos, arr, pos+1, count);
    }

	public static void main(String[] args) {
		System.out.println(getRandomInt(1, 10));
		System.out.println(getRandomInt(10, 1));
	}
}
