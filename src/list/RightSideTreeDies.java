package list;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

// stock span algorithm
public class RightSideTreeDies {

	public static void main(String[] args) {
		int[] values = {6, 5, 8, 4, 7, 10, 9};
		
		// Converting array into a list Arrays.asList() will create a read only list
		List<Integer> list = Arrays.stream(values)
				.boxed()  // need to do boxing because of primitive int
                .collect(Collectors.toList());
		System.out.println("Days: " + howManyDays(list));

	}
	
	// Brute force but times out
	private static int howManyDays(List<Integer> p) {
		int days = 0;
		boolean done = false;
		while (!done) {
			int len = p.size();
			boolean deleted = false;
			for (int i = len - 1; i > 0; i--) {
				if (p.get(i) > p.get(i-1)) {
				    p.remove(i);
				    deleted = true;
				}
			}
			
			if (deleted == true) {
				days++;
			} else {
				done = true;
			}
		}
		return days;
	}
	
	// we need to apply Stock span algorithm
	// https://leetcode.com/problems/online-stock-span/
}
