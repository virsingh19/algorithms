package dp;

//https://www.hackerearth.com/practice/algorithms/dynamic-programming/introduction-to-dynamic-programming-1/tutorial/
public class SellWine {
	public static void main(String[] args) {
		//int prices[] = {1, 4, 2, 3}; // wine prices
		//int prices[] = {2, 3, 4, 1, 5};
		int prices[] = {2, 3, 5, 1, 4}; // wine prices
		int dp[][] = new int[prices.length][prices.length];
		
		int sale = dpSaleAmount(prices, 0, prices.length-1, 1, dp); // N is the total number of wines
		System.out.println("Sale: " + sale);
	}
	
	public static int dpSaleAmount(int prices[], int startIndex, int endIndex, int year, int dp[][]) {
		// if you already have sale amount for this sub segment, then return it
		if (dp[startIndex][endIndex] > 0) {
			return dp[startIndex][endIndex];
		}
		
		// base condition
		if (startIndex == endIndex) {
			dp[startIndex][endIndex] = prices[startIndex]*year;;
			return dp[startIndex][endIndex];
		}
		
		// Either you can sell it from left or right
		// if you sell it from the left
		// price = year * prices[startIndex] + remaining from start+1 to end
		int p1 = year * prices[startIndex] + dpSaleAmount(prices, startIndex+1, endIndex, year+1, dp);
		
		// if you sell it from the right
		// price = year * prices[endIndex] + remaining from start to end-1
		int p2 = year * prices[endIndex] + dpSaleAmount(prices, startIndex, endIndex-1, year+1, dp);
        
		// we need the maximum selling amount
		int maxSellAmount = Math.max(p1, p2);
		dp[startIndex][endIndex] = maxSellAmount;
		return maxSellAmount;
	}
}
