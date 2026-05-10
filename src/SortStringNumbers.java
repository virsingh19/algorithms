import java.util.Arrays;
import java.util.Comparator;

public class SortStringNumbers {
    // Sort an array of strings which represent numbers in ascending order.
    public static void main(String[] args) {
        String[] strs = {"1", "22", "44", "8", "6"};
        
        bigSorting(strs);

        for (String str : strs) {
            System.out.println(str);
        }

    }
    
    static String[] bigSorting(String[] strs) {
        // Complete this function, main task is to write the comparator
        Arrays.sort(strs, new StringComparator());
        
        return strs;
    }
}

class StringComparator implements Comparator<String> {
    @Override
    public int compare(String s1, String s2) {
        // whichever length is bigger, is the bigger string
        // if length us same, then we need to check the strings character by character
        int len1 = s1.length();
        int len2 = s2.length();
        
        return (len1 != len2) ? (len1-len2) : checkStrings(s1, s2);
    }
    
    public int checkStrings(String s1, String s2) {
        int len = s1.length();

        // from left, whichever char is bigger, is the bigger string
        for (int i = 0; i < len; i++) {
            if ((int)s1.charAt(i) != (int)s2.charAt(i)) {
                return (int)s1.charAt(i) - (int)s2.charAt(i);
            }
        }
        return 0;
    }
}
