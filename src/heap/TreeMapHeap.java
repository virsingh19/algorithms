package heap;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.SortedMap;
import java.util.TreeMap;

public class TreeMapHeap {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
    	//printMinValue();
    	//System.out.println(arrayFirstTwoNumbers());
    	System.out.println(mixupFirstTwoNumbers());
    }
    
    //======================================================================================
    // Priority Queue
    // int[] ints = {1,2,3};
    // List<Integer> list = Arrays.stream(ints).boxed().collect(Collectors.toList());
    //======================================================================================
	public static int mixupFirstTwoNumbers() {
		// By default the priority que will be in the increasing order
		// first element will be known as head
		//List<Integer> list = Arrays.stream(ints).boxed().collect(Collectors.toList());
		
		int[] A = {6214,8543,9266,1150,7498,7209,9398,1529,1032,7384,6784,34,1449,7598,8795,756,7803,
				4112,298,4967,1261,1724,4272,1100,9373};
		int k = 3581;
		
		// Converting int[] to PriorityQueue
		PriorityQueue<Integer> que = new PriorityQueue<>();
		Arrays.stream(A)./*parallel().*/forEach(a -> que.add(a));
		
		// Internally it maintains a tree, so the printing of elements may not display the right order
		// however when the elements are removed using poll() or remove(), they will be in the correct order
		// poll() on empty queue will not throw exception whereas remove() would, thats the only difference
		// System.out.println(que);

		int operations = 0;
		while (que.size() > 1 && que.peek() < k) {
			// Remove first two elements
			int leastSweet = que.poll();
			int secondLeast = que.poll();

			que.add(leastSweet + 2 * secondLeast);
			operations++;
		}

		if (que.size() == 0 || que.peek() < k) {
			return -1;
		} else {
			return operations;
		}
	}
    
	public static int arrayFirstTwoNumbers() {
		//int[] A = {9, 1, 12, 3, 10, 2}; // k = 7
		int[] A = {6214,8543,9266,1150,7498,7209,9398,1529,1032,7384,6784,34,1449,7598,8795,756,7803,
				4112,298,4967,1261,1724,4272,1100,9373};
		int k = 3581;

		Arrays.sort(A);
		Arrays.stream(A).forEach(System.out::println);

		if (A.length == 0 || (A.length == 1 && A[0] < k)) {
			return -1;
		}
		
		int operations = 0;
		int start = 0;
		while (start < (A.length - 1) && A[start] < k) {
			int value = A[start] + 2 * A[start+1];
			start++;
			A[start] = value;
			operations++;
			
			// place new element to its right position
			while ((A[start] > A[start+1]) && (A[start+1] < k)) {
				int i = start+1;
				for (;A[i] < A[start]; i++);
				// Interchange the elements
				int temp = A[start];
				A[start] = A[i-1];
				A[i-1] = temp;
			}
		}
		
		if (A[start] < k) {
			return -1;
		}
		
		return operations;
	}
	
    //======================================================================================
    // Insert/Delete a value, then find the minimum
    //======================================================================================
    private static void printMinValue() {
        SortedMap<Integer, Integer> map = new TreeMap<>();
        String[] tokens = scanner.nextLine().split(" ");
        int count = Integer.parseInt(tokens[0].trim());
        while (count > 0) {
            tokens = scanner.nextLine().split(" ");
            int opr = Integer.parseInt(tokens[0].trim());
            int value = 0;
            if (opr == 1 || opr == 2) {
                value = Integer.parseInt(tokens[1].trim());
            }

            heapOperation(opr, value, map);

            count--;
        }
    }
    private static void heapOperation(int opr, int value, SortedMap<Integer, Integer> map) {
        if (opr == 1) {
            // Insert
            Integer count = map.get(value);
            if (count == null) {
                map.put(value, 1);
            } else {
                map.replace(value, count + 1);
            }
        } else if (opr == 2) {
            // Delete
            Integer count = map.get(value);
            if (count != null) {
                if (count > 1) {
                    map.replace(value, count - 1);
                } else {
                    map.remove(value);
                }
            }
        } else if (opr == 3 && map.size() > 0) {
            System.out.println(map.firstKey());
        }
    }
}
