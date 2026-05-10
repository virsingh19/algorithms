import java.util.Scanner;

public class InputReader {
	private static final Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		//Read a line of values
	    String[] tokens = scanner.nextLine().split(" ");
	    int n1 = Integer.parseInt(tokens[0].trim());
	    int n2 = Integer.parseInt(tokens[1].trim());
	    int n3 = Integer.parseInt(tokens[2].trim());

	    int[] h1 = new int[n1];
	    String[] h1Items = scanner.nextLine().split(" ");
	    for (int h1Itr = 0; h1Itr < n1; h1Itr++) {
	        int h1Item = Integer.parseInt(h1Items[h1Itr].trim());
	        h1[h1Itr] = h1Item;
	    }
	}
}
