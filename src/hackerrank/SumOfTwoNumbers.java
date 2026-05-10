package hackerrank;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SumOfTwoNumbers {

	// Check if there are two numbers in the array that add up to a given sum.
	public static void main(String[] args) {
		 int[] nums = {1, 4, 45, 6, 3, 10, -8, 8};
		 int sum = 11;

		 System.out.println("Input array: " + Arrays.toString(nums));
		 SumOfTwoNumbers s = new SumOfTwoNumbers();
		 System.out.println(s.setCheck(nums, sum));
	}

	// Think about concurrent hash set as well
	public List<List<Integer>> setCheck(int[] nums, int target) {
		List<List<Integer>> result = new ArrayList<>();

		Set<Integer> set = new HashSet<>();
		for (int num : nums) {
			int complement = target - num;

			if (set.contains(complement)) {
				// Sort the numbers first
				List<Integer> pair = Stream.of(num, complement).sorted().collect(Collectors.toList());
				result.add(pair);
			}

			// Keep adding the numbers to the set
			set.add(num);
		}

		return result;
	}

	// This method is more efficient than the mapCheck method
	// but it requires the array to be sorted first.
	public List<List<Integer>> arrayCheck(int nums[], int target) {
		List<List<Integer>> result = new ArrayList<>();

		Arrays.sort(nums);
		
		int left = 0;
		int right = nums.length-1;
		
		while (left < right) {
			int checkSum = nums[left] + nums[right];
			
			if (checkSum == target) {
				List<Integer> pair = Stream.of(nums[left], nums[right]).sorted().collect(Collectors.toList());
				result.add(pair);

			} else if (checkSum < target) {
				left++;
			} else {
				right--;
			}
		}
		
		return result;
	}
}
