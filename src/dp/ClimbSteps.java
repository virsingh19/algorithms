package dp;

/* How many no of ways you can climb n numbers of stairs if you are allowed to take
 * either 1 or 2 steps at a time randomly.
 */
public class ClimbSteps {
	public static void main(String[] args) {
		// -ve and 0 are to test invalid no of steps
		int numOfSteps[] = {-2, 0, 1, 2, 3, 4, 6};
		
		for (int i = 0; i < numOfSteps.length; i++) {
			// using recursion
		    System.out.println("Steps " + numOfSteps[i] +": " + getCombUsingDP(numOfSteps[i]));
		    // using dp
		    System.out.println("Steps " + numOfSteps[i] +": " + getCombinations(numOfSteps[i]));
		}
	}
	
	// Based on pure recursion
	public static int getCombinations(int n) {
		if (n <= 0) {
			return 0;
		}
		
		if (n > 0 && n <= 2) {
			return n;
		}
		
		return getCombinations(n-1) + getCombinations(n-2);
	}
	
	// This is similar to the coin change problem
	public static int getCombUsingDP(int n) {
		if (n <= 0) {
			return 0;
		} else if (n == 1) {
			return 1;
		}
		
		int[] dp = new int[n + 1];  // 0th index is not used
		dp[1] = 1;
		dp[2] = 2;
		for (int i = 3; i <= n; i++) {
			dp[i] = dp[i - 1] + dp[i - 2];
		}
		return dp[n];
	}
}
