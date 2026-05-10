package dp;
/*
Let f(i,j,k) be the number of subsets of size j and sum k, of first i elements of X. Define f(i,j,k) to be 0
whenever either of i,j,k is negative. Then f(0, 0, 0) = 1 and we have the following recurrence relation: 

f(i,j,k) = f(i-1,j,k) + f(i-1,j-1,k-xi)

This can be computed using dp. The complexity is O(r*m^2), because i<=m, j<=m, k<=r

2*sum(xi) = r+s or r-s
*/

//4 5 3
//1 1 1 4
public class SubsetSolution {
	public static void main(String args[]) {
		long mod = 1000000007;
		int dp[][][] = new int[105][105][2005]; 
		int arr[] = {1, 1, 1, 4};
	    int m = 4, r = 5, s = 3;
	    
	    //if ((r+s)&1 > 0 || r < s) {
	    if ((r+s)%2 > 0 || r < s) {
	    	System.out.println("0");
	    	return;
	    }
	    
	    int sumof=(r+s)/2;
	    
	    dp[0][0][0]=1; 
	    //long ansfirst=0, anssecond=0; 
	    for (int g = 1; g <= m; g++) {
	       for (int z = 0; z <= m; z++) {
	            for (int y = 0; y <= sumof; y++) {
	                dp[g][z][y] = dp[g-1][z][y]; 
	                if (arr[g] <= y && z >= 1) {
	                	dp[g][z][y] += dp[g-1][z-1][y-arr[g]]; 
	                }
	                dp[g][z][y] %= mod;
	            }
	        }
	    }
	    
	    long ans = 0; 
	    for (int g = 1; g <= m; g++) {
	        ans += dp[m][g][(r+s)/2] * dp[m][g][(r-s)/2]; 
	        ans %= mod; 
	    }
	    System.out.println(ans);
	}
}
