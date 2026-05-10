package recursion;
import java.util.HashMap;
import java.util.Map;

public class Recursion {
	public static int fibonacci(int n) {
		if (n < 0) {
			return 0;
		} else if (n == 0 || n == 1) {
			return n;
		}
		
		return fibonacci(n-1) + fibonacci(n-2);
	}

	static Map<Integer, Integer> stepMap = new HashMap<>();
    static int stepPerms(int n) {
    	// failing because of time out
        if (n == 1 || n == 2) { // n = 2: 1 1, 2
        	stepMap.put(n, n);
            return n;
        } else if (n == 3) {
        	stepMap.put(n, 4);
            return 4; // 1 1 1, 2 1, 1 2, 3
        }
        
        int n1, n2, n3;
        if (stepMap.get(n - 1) != null) {
        	n1 = stepMap.get(n - 1);
        } else {
        	n1 = stepPerms(n-1);
        }
        
        if (stepMap.get(n - 2) != null) {
        	n2 = stepMap.get(n - 2);
        } else {
        	n2 = stepPerms(n-2);
        }
        
        if (stepMap.get(n - 3) != null) {
        	n3 = stepMap.get(n - 3);
        } else {
        	n3 = stepPerms(n-3);
        }
        
        int combinations = n1 + n2 + n3;
        stepMap.put(n, combinations);
        return combinations;
    }
    
    public static long superDigit(long num) {
    	if (num < 10) {
    		return num;
    	}
    	long sum = String.valueOf(num).chars().map(ch -> ch - '0').reduce(0, Integer::sum);
    	return superDigit(sum);
    }
    
	public static void main(String[] args) {
		System.out.println(superDigit(68));
	}
}
