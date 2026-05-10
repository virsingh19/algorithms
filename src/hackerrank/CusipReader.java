package hackerrank;

import utils.FileLineReader;

public class CusipReader {
	public static void main(String[] args) {
        FileLineReader fr = new FileLineReader("C:\\temp\\ticker.txt");
        String line = null;
        String cusip = null;
        String price = null;
        
        while ((line = fr.readLine()) != null) {
        	if (isCusip(line)) {
        		if (cusip != null) {
        			System.out.println(cusip +":"+price);
        		}
        	    cusip = line;  // new cusip
        	    price = null;  // price reset for new cusip
        	} else {
        		price = line;
        	}
        }
        System.out.println(cusip +":"+price);
	}
	
	public static boolean isCusip(String str) {
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == '.') {
				return false;
			}
		}
		return true;
	}
}
