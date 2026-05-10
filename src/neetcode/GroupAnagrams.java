package neetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//Anagram words: words made of same set of characters and same length are anagrams
//e.g. act, cat, tac are anagrams
//let us utilize the fact that a character sorting of anagrams would yield the same output word
public class GroupAnagrams {
    public static void main(String[] args) {
    	String textBlock = "apt node tap you find pat all work done";
    	// Let us create an array of words
    	String[] words = textBlock.split(" ");
    	// build a map of words (key = <word>, value = <sorted value of word>
    	// so all anagramic words will have same value
    	Map<String, Set<String>> map = buildMap(words);
    	printMap(map);
    }

    // build a map of words against its sorted value
    private static Map<String, Set<String>> buildMap(String[] words) {
    	Map<String, Set<String>> map = new HashMap<>();
    	Set<String> set;
    	String sortedStr;

        for (String word : words) {
            sortedStr = sortString(word);
            // If the key doesn't exist, it will create a new HashSet
            // i.e. first time we need to create one and set it against the key
            // otherwise it will return the existing set and we can add the word to it
            set = map.computeIfAbsent(sortedStr, k -> new HashSet<>());
            set.add(word);
        }
    	
    	return map;
    }

    // return a sorted string of a given string
    private static String sortString(String str) {
        char[] charArray = str.toCharArray();
        Arrays.sort(charArray);
        return new String(charArray);
    }

    private static void printMap(Map<String, Set<String>> map) {
    	Set<String> set;
    	
    	for (Map.Entry<String, Set<String>> entry : map.entrySet()) {
    		set = entry.getValue();
            for (String s : set) {
                System.out.print(s + " ");
            }
    		System.out.println();
    	}
    }
}
