package array;
import java.util.LinkedList;
import java.util.List;

public class ConvertToArray {

	public static void main(String[] args) {
		printArray(getArrayJava7());
		printArray(getArrayJava8());
	}
	
	public static int[] getArrayJava7() {
		List<Integer> list = new LinkedList<>();
		
		list.add(4); list.add(2); list.add(9);
		int[] array = new int[list.size()];
		
		for (int i = 0; i < list.size(); i++) {
			array[i] = list.get(i);
		}
		
		return array;
	}
	
	public static int[] getArrayJava8() {
		List<Integer> list = new LinkedList<>();
		
		list.add(4); list.add(2); list.add(9);
	    int[] array = list.stream().mapToInt(i->i).toArray();
	    
	    return array;
	}
	
	public static void printArray(int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println("");
	}
}
