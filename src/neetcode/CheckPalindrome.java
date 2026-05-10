package neetcode;

/*
A palindrome is a string that reads the same forward and backward. It is also case-insensitive and ignores
all non-alphanumeric characters.
 */
public class CheckPalindrome {
    public static void main(String[] args) {
        String s = "Was it a car or a cat I saw?";
        isPalindrome(s);
    }

    public static boolean isPalindrome(String s) {
        String cleaned = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        String reversed = new StringBuilder(cleaned).reverse().toString();
        return cleaned.equals(reversed);
    }
}
