package heap;

import java.util.Comparator;
import java.util.PriorityQueue;
/*
This Java program computes the running median of an array of integers as each element
is added sequentially. It uses two heaps (a min-heap for the larger half and a max-heap
for the smaller half) to maintain balance and efficiently calculate the median at each
step. For the example array {12, 4, 5, 3, 8, 7}, it prints the median after each addition.
 */
public class RunningMedian {
	public static void main(String[] args) {
		int[] a = {12, 4, 5, 3, 8, 7};
		
		runningMedian(a);
	}
	
	static double[] runningMedian(int[] a) {
		double[] result = new double[a.length];
		// minHeap will have higher side numbers in increasing order
		// whereas the maxHeap will have lower side numbers in the decreasing order
		// this way the median numbers will on the head side of both the heaps
		PriorityQueue<Integer> minHeap = new PriorityQueue<>();
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());

		for (int i = 0; i < a.length; i++) {
			int currentValue = a[i];
			if (minHeap.isEmpty() || currentValue > minHeap.peek()) {
				minHeap.add(currentValue);
			} else {
				maxHeap.add(currentValue);
			}

			rebalanceHeaps(minHeap, maxHeap);
			result[i] = getMedian(minHeap, maxHeap);
			
			System.out.println(result[i]);
		}
		
		return result;
	}

	private static double getMedian(PriorityQueue<Integer> minHeap, PriorityQueue<Integer> maxHeap) {
		if (minHeap.size() > maxHeap.size()) {
			return (double) minHeap.peek();
		} else if (maxHeap.size() > minHeap.size()) {
			return (double) maxHeap.peek();
		} else { // (minHeap.size() == maxHeap.size())
			return ((double) (minHeap.peek() + maxHeap.peek())) / 2;
		}
	}

	private static void rebalanceHeaps(PriorityQueue<Integer> minHeap, PriorityQueue<Integer> maxHeap) {
		while (Math.abs(minHeap.size() - maxHeap.size()) > 1) {
			if (minHeap.size() > maxHeap.size()) {
				maxHeap.add(minHeap.poll());
			} else{
				minHeap.add(maxHeap.poll());
			}
		}
	}
}
