package hackerrank;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class PatternMatcher {
	String start;
	Set<String> ends;
	Map<String, Map<Character,String>> transitions; // state -> (character -> next state)

	/**
	 * Constructs the DFA from the arrays, as specified in the overall header
	 */
	PatternMatcher(String[] ss, String[] ts) {
		ends = new TreeSet<String>();
		transitions = new TreeMap<String, Map<Character,String>>();

		// States
		for (String v : ss) {
			String[] pieces = v.split(",");
			if (pieces.length>1) {
				if (pieces[1].equals("S")) start = pieces[0];
				else if (pieces[1].equals("E")) ends.add(pieces[0]);
			}
		}

		// Transitions
		for (String e : ts) {
			String[] pieces = e.split(",");
			String from = pieces[0], to = pieces[1];
			if (!transitions.containsKey(from)) transitions.put(from, new TreeMap<Character,String>());
			for (int i=2; i<pieces.length; i++) {
				transitions.get(from).put(pieces[i].charAt(0), to);				
			}
		}

		System.out.println("start:"+start);
		System.out.println("end:"+ends);
		System.out.println("transitions:"+transitions);
	}

	/**
	 * Returns whether or not the DFA accepts the string --
	 * follows transitions according to its characters, landing in an end state at the end of the string
	 */
	public boolean match(String s) {
		String state = start;
		for (int i=0; i<s.length(); i++) {
			char c = s.charAt(i);
			if (!transitions.get(state).containsKey(c)) {
				System.out.println("This isn't a DFA! No transition from "+state+" for "+c);
				return false;
			}
			state = transitions.get(state).get(c);
		}
		return ends.contains(state);
	}

	/**
	 * Helper method to test matching against a bunch of strings, printing the results
	 */
	public void test(String[] inputs) {
		for (String s : inputs)
			System.out.println(s + ":" + match(s));
	}

	public static void main(String[] args) {
		String[] ss1 = { "A,S", "B,E", "C" };
		String[] ts1 = { "A,B,0", "A,C,1", "B,B,0,1", "C,C,0,1" };
		PatternMatcher dfa1 = new PatternMatcher(ss1, ts1);

		String[] testsT1 = { "0", "00", "00000", "0010101" };
		dfa1.test(testsT1);
		String[] testsF1 = { "", "1", "1100110" };
		dfa1.test(testsF1);
	}
}



/*
The program should monitor a possibly infinite stream of characters from the
keyboard (standard input).  If it detects the sequence "aaa" it outputs a "0".  If it detects the sequence
"aba" it outputs a "1".  DO NOT detect sequences within sequences.  The program should exit cleanly when it
detects an End Of Input.  For example:

The following sequence  aababaaabaaa<End Of Input>  would produce the following result:   100
While the following sequence   aaababaaaabbababa<End Of Input>   would produce the following result:   0101

Hint:  Your code should emphasize simplicity & speed.
 */
