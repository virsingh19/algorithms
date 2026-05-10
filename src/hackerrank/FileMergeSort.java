package hackerrank;
import utils.FileLineReader;

// This program merges two sorted files line by line and prints the merged output to the console.
public class FileMergeSort {
	public static void main(String[] args) {
        FileLineReader fr1 = new FileLineReader("C:\\temp\\f1.txt");
        FileLineReader fr2 = new FileLineReader("C:\\temp\\f2.txt");
        
        String line1 = null;
        String line2 = null;
        
        while (true) {
            line1 = readLine(fr1, line1);
        	line2 = readLine(fr2, line2);
        	if (line1 == null && line2 == null) {
        		break; // All the lines are processed
        	}
        	
        	// Whichever line is processed, set it to null, so that it can be read again
	    	if (line1 == null) {
	    		// file1 is done, print remaining file2
	    		line2 = printLine(line2);
	    	} else if (line2 == null) {
	    		// file2 is done, print remaining file1
	    		line1 = printLine(line1);
	    	} else if (line1.compareTo(line2) <= 0) {
	    		//print from file1
	    		line1 = printLine(line1);
	    	} else {
	    		//print from file2
	    		line2 = printLine(line2);
	    	}
        }
	}
	
	private static String readLine(FileLineReader fr, String str) {
		// only read if str is null otherwise keep the previous value only
		return (str != null) ? str : fr.readLine();
	}
	
	private static String printLine(String str) {
		// Once the line is processed, set it to null
		System.out.println(str);
		return null;
	}
}
