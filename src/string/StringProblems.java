package string;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class StringProblems {
	public static void main(String[] args) {
		//System.out.println(rotateChars("middle-Outz", 2));
		int[] queries = {6, 1, 3, 12, 5, 9, 10};
		// System.out.println(removeDuplicate("ABABABAB"));

		System.out.println(removeConsecutiveDuplicates("aaaabccc"));
		System.out.println(deleteDupCharsRecursively("aaaabcc"));
	}

	public static int countUpperCase(String s) {
		return (int)s.chars().filter(Character::isUpperCase).count();
	}

	// check if string has duplicate characters, if yes return the count of duplicates
	public static int hasDuplicate(String s) {
		long uniqueCount = s.chars().distinct().count();

		return s.length() - (int)uniqueCount;
	}

	// If any two consecutive chars are same, return false
	static boolean areAlternativeCharacterSame(String s) {
		for (int i = 0; i < s.length() - 1; i++) {
			if (s.charAt(i) == s.charAt(i+1)) {
				return false;
			}
		}
		return true;
	}

	// Maintain a hashset to check if the char is already present
	// it is keeping one char out of duplicates
	public static String removeDuplicate(String s) {
		Set<Character> set = new HashSet<>();
		StringBuilder sb = new StringBuilder();

		for (char ch : s.toCharArray()) {
			if (!set.contains(ch)) {
				set.add(ch);
				sb.append(ch);
			}
		}

		return sb.toString();
	}

	// aaaabccc -> bc
	public static String removeConsecutiveDuplicates(String input) {
		// if string is null or empty or has only one char, return as is
		if (input == null || input.isEmpty() || input.length() == 1) {
			return input;
		}

		// aaaaabccc
		StringBuilder result = new StringBuilder();

		for (int i = 0; i < input.length() - 1; i++) {
			// if current char is same as next one, skip both
			if (input.charAt(i) == input.charAt(i + 1)) {
				i++; // skip the next char as well
			} else {
				result.append(input.charAt(i));
			}

			if (i == input.length() - 2) {
				// we still have one last left
				result.append(input.charAt(i+1));
			}
		}

		return result.toString();
	}

	// abbaca -> aaca -> ca
	private static String deleteDupCharsRecursively(String str) {
		str = "abbaca";
		StringBuilder stack = new StringBuilder();
		for (char c : str.toCharArray()) {
			int len = stack.length();
			// If stack is not empty and top element matches current char
			if (len > 0 && stack.charAt(len - 1) == c) {
				stack.deleteCharAt(len - 1); // Remove the pair
			} else {
				stack.append(c); // Add to stack
			}
		}
		return stack.toString();
	}


	/*
	 * Its length is at least 6
     * It contains at least one digit.
     * It contains at least one lowercase English character.
     * It contains at least one uppercase English character.
     * It contains at least one special character. The special characters are: !@#$%^&*()-+
	 */
	private static boolean checkForPasswordChars(String s) {
		// Check the length first
		if (s == null || s.length() < 6) {
			return false;
		}
		// flags for each condition
		boolean[] checks = {false, false, false, false};
		
		for (char ch : s.toCharArray()) {
			if (Character.isDigit(ch)) checks[0] = true;
			if (Character.isLowerCase(ch)) checks[1] = true;
			if (Character.isUpperCase(ch)) checks[2] = true;
			if (isSpecial(ch)) checks[3] = true;
		}
		
		// Check how many conditions are missing other than the length
		int missingCount = 0;
		for (boolean b : checks) {
			if (!b) missingCount++;
		}
		
		System.out.println("Missing conditions: " + missingCount);
		return missingCount == 0;
	}
	
	private static boolean isSpecial(char ch) {
		for(char c : "!@#$%^&*()-+".toCharArray()) {
			if (c == ch) {
				return true;
			}
		}
		
		return false;
	}
	
	static int twoCharacters(String s) {
		// create a set of chars
	    Set<Character> charSet = new HashSet<>();
	    for (char ch : s.toCharArray()) {
	    	charSet.add(ch);
	    }

	    // Create char[] array from set
	    Character[] uniqueCharArr = charSet.toArray(new Character[0]);
	    //System.out.println("Char array: " + Arrays.asList(charArr));
	    
	    int maxLen = 0;
	    
	    // process combinations of all possible two characters
	    for (int i = 0; i < uniqueCharArr.length - 1; i++) {
	    	for (int j = i+1; j < uniqueCharArr.length; j++) {
	    		// remove all other chars then these two, may utilize regex e.g. ^[ab]$
	    		final char ch1 = uniqueCharArr[i];
	    		final char ch2 = uniqueCharArr[j];
	    	    String str = s.chars().filter(code -> code == ch1 || code == ch2)
	    				.mapToObj(num -> String.valueOf((char)num))
	    				.collect(Collectors.joining());
	    		if (areAlternativeCharacterSame(str)) {
	    			//System.out.println(str);
	    			maxLen = Math.max(str.length(), maxLen);
	    		}
	    	}
	    }

	    return maxLen;
	}

	// Rotate characters
	public static String rotateChars(String str, int pos) {
		char[] chars = str.toCharArray();
		
		for (int i = 0; i < chars.length; i++) {
			if (Character.isUpperCase(chars[i])) {
				chars[i] = (char)(((chars[i] - 'A' + pos) % 26) + 'A');
			} else if (Character.isLowerCase(chars[i])) {
				chars[i] = (char)(((chars[i] - 'a' + pos) % 26) + 'a');
			}
		}
		
		return new String(chars);
	}
	
	// Ignore case and see if all the alphabets are present in the string
	public static boolean isPangram(String s) {
		
		Set<Character> set = new HashSet<>();
		for (char ch : s.toCharArray()) {
			if (Character.isLetter(ch)) {
				set.add(Character.toUpperCase(ch));
			}
		}

        return set.size() == 26;
    }
	
	/*
	 * Each letter has a weight starting from 'a' = 1, 'b' = 2 etc.
	 * Find a sum of weights of a same letter substring
	 * Check if some substring has a given weight
	 */
	public static void weightOfSubstring(String s, int[] queries) {
		String[] outStr = new String[queries.length];
		
		// convert string to lower case
		s = s.toLowerCase();
		Set<Character> set = new HashSet<>();
		for (char ch : s.toCharArray()) {
			if (Character.isLetter(ch)) {
				set.add(Character.toLowerCase(ch));
			}
		}
		
		// For each letter in the set, find a regex for same letter substring
		// and build a frequency set
		Set<Integer> weightSet = new HashSet<>();
		for (char ch : set) {
	        String[] arr = s.split("[^"+ch+"]+");

            for (String string : arr) {
                if (!string.isEmpty()) {
                    System.out.println("Matched: <" + string + ">");

                    // Add every length combination
                    for (int j = 1; j <= string.length(); j++) {
                        weightSet.add(j * (string.charAt(0) - 'a' + 1));
                    }
                }
            }
		}
		
		System.out.println("Set: " + weightSet);
		
        for (int i = 0; i < queries.length; i++) {
            if (weightSet.contains(queries[i])) {
                outStr[i] = "Yes";
            } else {
                outStr[i] = "No";
            }
            
            System.out.println(queries[i] +": "+ outStr[i]);
        }
	}
}
