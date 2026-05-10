package dp;

public class SubsetIntegers {
	/* Driver program to test above function */
	public static void main (String args[])
	{
		int array[] = {7, 3, 4, 12, 5, 2};
		int sum = 9;
		int n = array.length;
		if (isSubsetSum(array, n, sum) == true)
			System.out.println("Found a subset with given sum");
		else
			System.out.println("No subset with given sum");
	}
	
	// Returns true if there is a subset of set[] with sum equal to given sum
	static boolean isSubsetSum(int array[], int n, int sum)
	{
		// Base Cases
		if (sum == 0)
			return true;
		if (n == 0 && sum != 0)
			return false;

		// If last element is greater than sum, then ignore it
		if (array[n-1] > sum)
			return isSubsetSum(array, n-1, sum);

		/* else, check if sum can be obtained by any of the following
	          (a) including the last element
	          (b) excluding the last element   */
		return isSubsetSum(array, n-1, sum) || isSubsetSum(array, n-1, sum - array[n-1]);
	}
}
