package string;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/*
 * String is valid if occurrence count of all the chars are same,
 * however if they all are not having same count, then count of one char can be reduced by one
 * to make them all same.
 * 1) All the characters have occurrence count of N
 * 2) If all the chars are having count of N, but one having N+1, this is a valid case
 * 3) Tricky scenario, if all are having a count of N, but one having a count of 1, if we reduce this
 * by one, it will get eliminated and then remaining will be fine.
 *
 * Solution: build a frequency map of char vs counts, then just build a set of counts
 * this set can have the following combinations:
 * 1) Only one count
 * 2) Two counts, one of them should be 1
 * 3) Two counts, one of them should be 1 more than the other
 */
public class ValidString {

	public static void main(String[] args) {
		String str = "ibfdgaeadiaefgbhbdghhhbgdfgeiccbiehhfcggchgghadhdhagfbahhddgghbdehidbibaeaagaeeigffcebfbaieggabcfbiiedcabfihchdfabifahcbhagccbdfifhghcadfiadeeaheeddddiecaicbgigccageicehfdhdgafaddhffadigfhhcaedcedecafeacbdacgfgfeeibgaiffdehigebhhehiaahfidibccdcdagifgaihacihadecgifihbebffebdfbchbgigeccahgihbcbcaggebaaafgfedbfgagfediddghdgbgehhhifhgcedechahidcbchebheihaadbbbiaiccededchdagfhccfdefigfibifabeiaccghcegfbcghaefifbachebaacbhbfgfddeceababbacgffbagidebeadfihaefefegbghgddbbgddeehgfbhafbccidebgehifafgbghafacgfdccgifdcbbbidfifhdaibgigebigaedeaaiadegfefbhacgddhchgcbgcaeaieiegiffchbgbebgbehbbfcebciiagacaiechdigbgbghefcahgbhfibhedaeeiffebdiabcifgccdefabccdghehfibfiifdaicfedagahhdcbhbicdgibgcedieihcichadgchgbdcdagaihebbabhibcihicadgadfcihdheefbhffiageddhgahaidfdhhdbgciiaciegchiiebfbcbhaeagccfhbfhaddagnfieihghfbaggiffbbfbecgaiiidccdceadbbdfgigibgcgchafccdchgifdeieicbaididhfcfdedbhaadedfageigfdehgcdaecaebebebfcieaecfagfdieaefdiedbcadchabhebgehiidfcgahcdhcdhgchhiiheffiifeegcfdgbdeffhgeghdfhbfbifgidcafbfcd";
		System.out.println(isStringValid(str));
		
		str = "aaaabbcc"; // "aabbcd"; "aaaabbcc";
		System.out.println(isStringValid(str));

		str = "aaaaccc"; // "aabbcd"; "aaaabbcc";
		System.out.println(isStringValid(str));
	}
	
	private static String isStringValid(String s) {
	    // Build a frequency map of char vs counts
		Map<Character, Long> map = s.chars().mapToObj(num -> (char) num).collect(
	    		Collectors.groupingBy(Function.identity(), Collectors.counting())
	    	);
	    System.out.println(map);

		// Build a set of counts
		List<Long> sortedlist = new HashSet<>(map.values()).stream().sorted().toList();
	    System.out.println(sortedlist);
	    
	    if (sortedlist.size() == 1) {
	    	return "YES";
	    } else if (sortedlist.size() == 2) {
	    	if (sortedlist.get(0) == 1 || sortedlist.get(1) - sortedlist.get(0) == 1) {
	    		return "YES";
	    	}
	    }
	    
	    return "NO";
	}
}
