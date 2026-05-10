package hackerrank;

// Java program to print all combinations of given size. The following is the implementation of the above approach.
public class NumberCombinations {
    // Combination: Order does not matter - fact(n)/fact(n-r)
	// Permutation: There could be different order variations with the same set of values - fact(n)/fact(n-r)*fact(r)

	/*Driver function to check for above function*/
	public static void main (String[] args) {
		int dataArray[] = {1, 2, 3, 4};
		int r = 2;
		int n = dataArray.length;
		printCombination(dataArray, n, r);
	}
	
	// The main function that prints all combinations of size r
	// in dataArray[] of size n. This function mainly uses combinationUtil()
	static void printCombination(int dataArray[], int n, int r)
	{
		// A temporary array to store all combination one by one
		int tempArray[] = new int[r];

		// Print all combination using temporary array 'tempArray[]'
		combinationUtil(dataArray, tempArray, 0, 0, r);
	}
	
	/*  dataArray[]  ---> Input Array
	    tempArray[] ---> Temporary array to store current combination
	    start & end ---> Staring and Ending indexes in dataArray[]
	    index       ---> Current index in tempArray[]
	    r           ---> Size of a combination to be printed  */
	static void combinationUtil(int dataArray[], int tempArray[], int start, int index, int r)
	{
		// Current combination is ready to be printed, print it
		if (index == r) {
			for (int j = 0; j < r; j++) {
				System.out.print(tempArray[j]+" ");
			}
			System.out.println("");
			return;
		}

		// replace index with all possible elements. The condition
		// "end-i+1 >= r-index" makes sure that including one element
		// at index will make a combination with remaining elements
		// at remaining positions
		int len = dataArray.length;
		for (int i = start; (i < len) && (len-i >= r-index); i++) {
			tempArray[index] = dataArray[i];
			combinationUtil(dataArray, tempArray, i+1, index+1, r);
		}
	}
}
