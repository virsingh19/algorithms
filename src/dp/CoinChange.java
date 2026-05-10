package dp;

import java.util.Arrays;

//https://www.hackerrank.com/challenges/coin-change/problem?isFullScreen=true
public class CoinChange {
	public static void main(String[] args) {
		// There is no constraints on the number of coins of any amount
		// Coin amounts available per unit
	    //int coins[] = {8, 3, 1, 2};
	    int coins[] = {8, 3, 5};
	    int amount = 12;  // Money amount to be broken down into smaller coins
	    
	    Arrays.sort(coins);
	    System.out.println("Count: " + simpleWay(amount, coins));
	    System.out.println("Count: " + getCombinations(amount, coins));  
	}

	// DP based on an array, assuming coins are in the sorted order
    public static long simpleWay(int amount, int[] coins) {
        int[] combinations = new int[amount+1];
        combinations[0] = 1; // Initial value

        for (int coin : coins) {
            for (int i = coin; i < combinations.length; i++) {
                combinations[i] += combinations[i - coin];
            }
        }

        return combinations[amount];
    }
    
    public static long getCombinations(int amount, int coins[]) {
        long coinCount = coins.length;
		long count1, count2;
		long dp[][] = new long[(int) (amount+1)][(int)coinCount];

		// Fill the entries for 0 value case (n = 0)
		for (int j = 0; j < coinCount; j++) {
			dp[0][j] = 1L;
		}
		
		// Fill rest of the table entries in bottom up manner  
		for (int i = 1; i < amount+1; i++) {
			for (int j = 0; j < coinCount; j++) {
				// Count of solutions excluding coinsArray[j]
				count1 = (j >= 1) ? dp[i][j-1] : 0L;
				
				// Count of solutions including coinsArray[j]
				count2 = ((i-coins[j]) >= 0) ? dp[i - (int)coins[j]][j] : 0L;

				// total count
				dp[i][j] = count1 + count2;
			}
		}
		return dp[(int)amount][(int)(coinCount-1)];
	}
}
