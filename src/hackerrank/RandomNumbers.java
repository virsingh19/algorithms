package hackerrank;
import java.util.Random;

public class RandomNumbers {

	public static void main(String[] args) {
		int start = 5;
		int end = 150;
		int count = 30;

		RandomNumbers rn = new RandomNumbers();
		int array[] = rn.getNumbers(start, end, count);
		rn.printArray(array);
	}
	
	public int[] getNumbers(int start, int end, int count) {
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
	
	public void printArray(int array[]) {
		for (int i = 0; i < array.length; i++) {
		    System.out.print(array[i] + " ");
		}
	}
}
