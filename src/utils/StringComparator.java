package utils;

import java.util.Comparator;

// Comparator for String formed numbers
class StringComparator implements Comparator<String> {
    @Override
    public int compare(String s1, String s2) {
        int len1 = ((java.lang.String) s1).length();
        int len2 = ((java.lang.String) s2).length();
        
        if (len1 != len2) {
            return (len1-len2);
        }
        
        return checkStrings(s1, s2);
    }
    
    public int checkStrings(String s1, String s2) {
        int len = s1.length();
        
        for (int i = 0; i < len; i++) {
            if ((int)s1.charAt(i) != (int)s2.charAt(i)) {
                return (int)s1.charAt(i) - (int)s2.charAt(i);
            }
        }
        return 0;
    }
}
