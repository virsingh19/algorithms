package array;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class PairsInArray {

	public static void main(String[] args) throws Exception {
		 /* Enter your code here. Read input from STDIN. Print output to STDOUT */
		// Read element count, sum, deduction
		Scanner in = new Scanner(System.in);
		String lineStr1 = in.nextLine();       // get the entire line after the prompt 
		String lineStr2 = in.nextLine(); 
		in.close();
		
		List<Integer> list = processKeyboardInput(lineStr1);
		if (list.size() != 3) {
			System.out.println("Invalid inputs");
			System.exit(-1);
		}
		int elementCount = list.get(0);
		int add = list.get(1);
		int minus = list.get(2);
		
		//Read elements
		list = processKeyboardInput(lineStr2);
		if (elementCount != list.size())  {
			System.out.println("Incorrect no of array elements");
			System.exit(-1);
		}
		
		// a+b = R, a-b = S,  2a = R+S, 2b = R-S
		long pairCount = 0;
		for (int i = 0; i < list.size(); i++) {
			int a = list.get(i);
			if (2*a == (add+minus)) {
				for (int j = 0; j < list.size(); j++) {
                    if (list.get(j)*2 == (add-minus)) {
                    	pairCount++;
                    }
				}
			}
		}
		
		System.out.println(pairCount%1000000007);
	}
	
	public static List<Integer> processKeyboardInput(String input) {
		List<Integer> list = new LinkedList<>();
        String tokens[] = input.split(" ");
		for (int i = 0; i < tokens.length; i++) {
			try {
			    list.add(Integer.parseInt(tokens[i]));
			} catch(Exception e) { }
		}

		return list;
	}
	
	public static Map<Integer, List<int[]>> prepareSets(int dataArray[], int add, int minus) {
		Map<Integer, List<int[]>> map = new HashMap<>();
		int count = 1 << dataArray.length;
		BitInteger bi = new BitInteger(0);
		
		for (int i = 1; i < count; i++) {
			
		}

		return map;
	}
}
