import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/*
 * Problem: Find out pair of integers such that a^3 + b^3 = c^ + d^3
 * and each number is in the range of 1 to 1000.
 * We can solve this problem by using a map where the key is the sum of
 * cubes and the value is a SET of pairs of integers that have that sum of cubes.
 */
public class CubeABCD {
	public static void main(String[] args) {
		Map<Long, Set<NumberPair>> map = new HashMap<>();
		Set<NumberPair> set;
		
		//build a map of pairs having same sum of cubes
		for (int a = 1; a <= 1000; a++) {
			for (int b = a; b <= 1000; b++) { // avoid duplicate traversal
				NumberPair pair = new NumberPair(a, b);
				long key = pair.cube();

				// If there is no value set yet, then create a new set
                set = map.computeIfAbsent(key, k -> new HashSet<>());

                // if set does not have the pair already, then add it
                set.add(pair);
			}
		}

		System.out.println("Size of map: " + map.size());
		
		// Print values which are having multiple pairs
		int rows = 0;
        for (long key : map.keySet()) {
            set = map.get(key);
            if (set.size() > 1) {
                rows++;
                System.out.println("[" + rows +"]: cube: " + key + " pairs: " + set);
            }
        }
	}
}

class NumberPair {
	private int a;
	private int b;
	
	public NumberPair(int a, int b) {
		this.a = a;
		this.b = b;
	}
	
	public long cube() {
		return ((long) a *a*a) + ((long) b *b*b);
	}

	@Override
	public String toString() {
		return "[a=" + a + ", b=" + b + "]";
	}

	@Override
	public int hashCode() {
		// This hasCode will be used in the Set (as value pairs)
		int min = Math.min(a, b);
		int max = Math.max(a, b);
		return (min << 16) | max;
	}


	@Override
	public boolean equals(Object obj) {
		// (1, 4) and (4, 1) are same pairs, so we need to check for both combinations
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof NumberPair other)) {
			return false;
		}
		if (this == obj) return true;

        return (a == other.a && b == other.b) || (a == other.b && b == other.a);
    }
}