package array;

/*
 * Actually this is a rotate list
 * We can use Collections.rotate(List, count);
 */
public class RotateArray {

	public static void main(String[] args) {
		int[] data = {1, 2, 3, 4, 5};
		rotateManyTimes(data, 8);
		
		for (int i = 0; i < data.length; i++) {
			System.out.print(data[i] + " ");
		}
		System.out.println("");
	}
	
	public static void rotateManyTimes(int[] data, int count) {
		count = count % data.length;
		if (count == data.length) {
			return;
		}
		
		for (int i = 0; i < count; i++) {
			rotateLeft(data);
		}
	}
	
	public static void rotateLeft(int[] data) {
		// Save the 0th element and copy the array
		int first = data[0];
		
		System.arraycopy(data, 1, data, 0, data.length-1);
		data[data.length-1] = first;
	}
}
