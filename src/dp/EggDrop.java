package dp;

//http://datagenetics.com/blog/july22012/index.html
public class EggDrop {
	public static void main(String args[]) {
	    int eggs = 2, floors = 10;
	    int cache[][] = new int[eggs+1][floors+1];
	    
	    // initialize the cache
	    for (int i = 0; i <= eggs; i++) {
	    	for (int j = 0; j <= floors; j++) {
	    		cache[i][j] = -1;
	    	}
	    }
	    System.out.printf("Floors: %d, Eggs: %d, drops: %d\n", floors, eggs, eggDrop(eggs, floors, cache, 1));
	}
	
	// Function to get minimum number of trials needed in worst case
	public static int eggDrop(int eggs, int floors, int cache[][], int level) {
	    // One floor then one try, no floors no tries
		// One egg, try as many times as there are floors
	    // one floor, one trial needed.
	    if (floors == 1 || floors == 0 || eggs == 1) {
	    	//System.out.println("Boundary - Eggs: " + (eggs) +", Floors: " + (floors));
	        return floors;
	    }
	 
	    int min = Integer.MAX_VALUE;
	    int count1, count2;
	    int drops;
	 
	    // Consider all droppings from 1st floor to kth floor and
	    // return the minimum of these values plus 1.
	    for (int i = 1; i <= floors; i++) {
	    	// If egg breaks, check lower floors with one less egg
	    	count1 = ((cache[eggs-1][i-1]) != -1)    ? cache[eggs-1][i-1]    : eggDrop(eggs-1, i-1, cache, level+1);
	    	
	    	// Egg does not break, then check only top floors
	    	count2 = ((cache[eggs][floors-i]) != -1) ? cache[eggs][floors-i] : eggDrop(eggs, floors-i, cache, level+1);
	    	
	    	//res = Math.max(count1,  count2);
	    	char broken = 'Y';
	    	if (count1 > count2) {
	    		drops = count1;
	    		//printSpaces(level);
	    		//System.out.print("Broken - Eggs: " + (eggs-1) +", Floors: " + (i-1) +", drops: " + drops);
	    	} else {
	    		drops = count2;
	    		broken = 'N';
	    		//printSpaces(level);
	    		//System.out.print("Not Broken - Eggs: " + (eggs) +", Floors: " + (floors-i) +", drops: " + drops);
	    	}
	    	
	        if (drops < min) {
	            min = drops;
	        }
	        printSpaces(level);
	        System.out.println(i + "/" + floors + "  - Min: " + (min+1) +", broken: " + broken +","+ count1 +","+ count2);
	    }
	 
	    // place it in the cache
	    cache[eggs][floors] = min+1;  // adding the current floor also
	    
	    return cache[eggs][floors];
	}
	
	public static void printSpaces(int level) {
		for (int i = 0; i < level; i++) {
			System.out.print("  ");
		}
	}
}
