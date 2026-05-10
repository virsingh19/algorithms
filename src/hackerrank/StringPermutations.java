package hackerrank;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

//Java program to print all permutations of a given string.
public class StringPermutations {
	static Set<String> set = new HashSet<>();   // Only unique combinations
	
	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder("RBBYYY");
		StringPermutations permutation = new StringPermutations();
		permutation.permute(sb, 0, sb.length() - 1);
		
		// print set values
		System.out.println("Total count: " + set.size());
		//for (int i = 0; i < 6; i++) {
			Iterator<String> iter = set.iterator();
			while (iter.hasNext()) {
				String value = iter.next();
				//if (value.charAt(i) == 'R') {
				    System.out.println(value);
				//}
			}
		//}
	}

	private void permute(StringBuilder sb, int left, int right) {
		if (left == right) {
			//System.out.println(sb);
			int index = sb.toString().indexOf('R');
			set.add(sb.toString().substring(0, index+1));
		} else {
			for (int i = left; i <= right; i++) {
				swap(sb, left, i);  // first swap is with itself, can be optimized
				permute(sb, left+1, right);
				swap(sb, left, i);
			}
		}
	}

	public void swap(StringBuilder sb, int i, int j) {
		char temp = sb.charAt(i);
		sb.setCharAt(i, sb.charAt(j));
		sb.setCharAt(j, temp);
	}
}