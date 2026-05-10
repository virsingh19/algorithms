package hackerrank;

public class StringCombinations {
	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder("ABCD");

		combo("", "ABCD");
		permute("", "ABCD");
		//combinations(sb, 0);
	}

	public static void combinations(StringBuilder sb, int pos) {
		for (int count = (sb.length() - pos - 1); count >= 0; count--) {
			spin(sb, pos);
			if ((pos+1) == sb.length()) {
				System.out.println(sb.toString());  // when you reach the last char, print the whole string
			} else {
				// Save state before recursion
				String str = sb.toString();
				combinations(sb, pos+1);
				// Restore the state
				sb.setLength(0);
				sb.append(str.toCharArray());
			}
		}
	}

	public static void spin(StringBuilder sb, int pos) {
		if (sb == null || pos < 0 || pos >= (sb.length()-1)) {
			return;
		}

		char ch = sb.charAt(sb.length() -1);
		for (int i = sb.length() -1; i > pos; i--) {
			sb.setCharAt(i, sb.charAt(i-1));
		}
		sb.setCharAt(pos,  ch);
	}

	static void combo(String prefix, String s) {
		int len = s.length();

		if (prefix.length() > 0) {
			System.out.println(prefix);
		    //System.out.println(prefix +",  "+ s);
		}
		
		for (int i = 0 ; i < len ; i++) {
			combo(prefix + s.charAt(i), s.substring(i+1));
		}
	}

	static void permute(String prefix, String s) {
		int len = s.length();
        
		if (len == 0) {
			System.out.println(prefix);
		}

		for (int i = 0 ; i < len ; i++) {
			String s1 = prefix + s.charAt(i);
			String s2 = s.substring(0, i) + s.substring(i+1, len);
			permute(s1, s2);
		}
	}
}
