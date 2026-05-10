package array;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

public class ArrayMaxDiffCount {
	public static void main(String[] args) {
		int[] data = {4, 6, 5, 3, 3, 1};
		List<Integer> list = getMaxCount(data, 1);
		
		System.out.println("Count: " + list.size());
		printList(list);
		
		SortedSet<Integer> set = new TreeSet<>();
		//set.contains();
		System.out.println("Sorted Set: " + set);
	}
	
	public static List<Integer> getMaxCount(int[] data, int diff) {
		Arrays.sort(data);
		List<Integer> list = null;
		List<Integer> tempList = null;
		
		
		for (int i = 0; i < data.length; i++) {
			tempList = getRightCount(data, i, diff);
			
			if ((list == null) || (list.size() < tempList.size())) {
				list = tempList;
			}
		}
			
		return list;
	}
	
	public static List<Integer> getRightCount(int[] data, int pos, int diff) {
		List<Integer> list = new LinkedList<>();
		
		list.add(data[pos]);
		for (int i = pos + 1; i < data.length; i++) {
			if (Math.abs(data[pos] - data[i]) <= diff) {
				list.add(data[i]);
			}
		}
		
		return list;
	}
	
	public static void printList(List<Integer> list) {
		if (list != null) {
			for (int i = 0; i < list.size(); i++) {
				System.out.print(list.get(i) +" ");
			}
			System.out.println("");
		}
	}
}
