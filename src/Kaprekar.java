import java.util.HashSet;
import java.util.Set;

public class Kaprekar {
    public static void main(String args[]) {
        int[] kaps = kaprekarNumbers(400, 700);
        
        for (int i = 0; i < kaps.length; i++) {
            System.out.print(kaps[i] + " ");
        }
    }
    
    static int[] kaprekarNumbers(int p, int q) {
        // Complete this function
        Set<Integer> set = new HashSet<>();
        
        while (p <= q) {
            if (isKaprekar(p)) {
                set.add(p);
            }
            p++;
        }
        
        System.out.println(set);
        
        int[] kaps = new int[set.size()];     
        int i = 0;
        for(Integer num : set) {
            kaps[i++] = num;
        }
        
        return kaps;
    }

    public static boolean isKaprekar(int num) {
        long squared = (long) num * num;
        String str   = String.valueOf(squared);
        String left  = str.substring(0, str.length() / 2);
        String right = str.substring(str.length() / 2);
        
        int numL = (left.isEmpty())  ? 0 : Integer.parseInt(left);
        int numR = (right.isEmpty()) ? 0 : Integer.parseInt(right);
        
        if (numR == 0) return false;
        
        if (numL + numR == num) {
            return true;
        } else {
            return false;
        }
    }
}
