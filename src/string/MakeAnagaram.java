package string;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.stream.Collectors;

/*
 * How many characters to delete from two strings to make them anagram of each other
 * Solution: make HashMap of char counts and compare
 */
public class MakeAnagaram {

	public static void main(String[] args) {
		String str1 = "BufferedReader";
		String str2 = "ROBOfeeder";
		
		Map<Character, Long> map1 = createMap(str1);
		Map<Character, Long> map2 = createMap(str2);

		System.out.println(compareMaps(map1, map2));
	}

	// Create a frequency sorted map of characters in the string
	private static Map<Character, Long> createMap(String str) {
		return str.chars().mapToObj(num -> (char) num)
			//.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
			.collect(Collectors.groupingBy(Function.identity(), TreeMap::new, Collectors.counting()));
	}
	
	private static long compareMaps(Map<Character, Long> map1, Map<Character, Long> map2) {
		long count = 0;
		
		for (Character ch : map1.keySet()) {
			if (map2.containsKey(ch)) {
				// both have the char, are they having same count?
				count += Math.abs(map1.get(ch) - map2.get(ch));
			} else {
				// map2 does not have this char
				count += map1.get(ch);
				System.out.println("Removing " + ch + " from map1");
			}
		}
		
		for (Character ch : map2.keySet()) {
			if (!map1.containsKey(ch)) {
				count += map2.get(ch);
				System.out.println("Removing " + ch + " from map2");
			}
		}
		
		System.out.println("Map1: " + map1);
		System.out.println("Map2: " + map2);
		
		return count;
	}
}
