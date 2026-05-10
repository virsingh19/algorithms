import java.util.Arrays;

public class FindSubString {
	
	public static void findSubstring() {
		String s1 = "adc";
		String s2 = "eidacdocadbo";
		
		// first convert into char arrays
		char[] c1 = s1.toCharArray();
		char[] c2 = s2.toCharArray();
		
		Arrays.sort(c1);
		
		// Allocate a temporary array
		char[] sub = new char[c1.length];
		
		for (int i = 0; i <= (c2.length - c1.length); i++) {
			System.arraycopy( c2, i, sub, 0, c1.length);
			//System.out.println(sub);
			Arrays.sort(sub);
			if (compare(c1, sub)) {
				System.out.println("Got a match at: " + i);
			}
		}
	}
	
	private static boolean compare(char[] c1, char[] c2) {
		for (int i = 0; i < c1.length; i++) {
			if (c1[i] != c2[i]) {
				return false;
			}
		}
		
		return true;
	}
	
	public static void check() {
		try {
			Float f1 = new Float("3.0");
			int x = f1.intValue();
			byte b = f1.byteValue();
			double d = f1.doubleValue();
			System.out.println(x + b + d);
		} catch(NumberFormatException e) {
			System.out.println("bad number");
		}
	}
	
	public static void main(String[] args) {
		check();
	}
	
}
