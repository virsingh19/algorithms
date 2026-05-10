
// https://www.nayuki.io/page/next-lexicographical-permutation-algorithm
public class Lexicographic {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        /* ab
        bb
        hefg
        dhck
        dkhc */
        
        String str = "dhck";
        str = nextLexicographical(str);
        System.out.println(str);
        
    }


    static String nextLexicographical(String str) {
        // Complete this function
        // Find longest non-increasing suffix
        char[] array = str.toCharArray();
        int i = array.length - 1;
        while (i > 0 && array[i - 1] >= array[i]) {
            i--;
            // Now i is the head index of the suffix
        }
        
        // Are we at the last permutation already?
        if (i <= 0) {
            return "no answer";
        }
        
        // Let array[i - 1] be the pivot
        // Find rightmost element that exceeds the pivot
        int j = array.length - 1;
        while (array[j] <= array[i - 1]) {
            j--;
            // Now the value array[j] will become the new pivot
            // Assertion: j >= i
        }
        
        // Swap the pivot with j
        char temp = array[i - 1];
        array[i - 1] = array[j];
        array[j] = temp;

        // Reverse the suffix
        j = array.length - 1;
        while (i < j) {
            temp = array[i];
            array[i] = array[j];
            array[j] = temp;
            i++;
            j--;
        }

        // Successfully computed the next permutation
        return String.valueOf(array);
    }
}

