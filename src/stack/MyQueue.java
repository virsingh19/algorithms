package stack;

import java.util.Stack;

public class MyQueue {
	public static void main(String[] args) {
		StackQueue q = new StackQueue();
		q.add(42);
		q.remove();
		q.add(14);
		System.out.println(q.peek());
		q.add(28);
		System.out.println(q.peek());
		q.add(60);
		q.add(78);
		q.remove();
		q.remove();
	}
}

// Creating LIFO (Queue) using two FIFOs (Stack)
class StackQueue {
	private final Stack<Integer> removeStack = new Stack<>();
	private final Stack<Integer> addStack = new Stack<>();
	private int bottomInAdd = 0;
	private int topInRemove = 0;
	
	// Add an element at the end of the queue
	public void add(int value) {
		if (addStack.isEmpty()) {
			bottomInAdd = value;
		}
		addStack.add(value);
	}
	
	// Remove the oldest element
	public void remove() {
		if (!removeStack.isEmpty()) {
			// If there are elements in removeStack, then top element is still the oldest
			removeStack.pop();
		} else if (!addStack.isEmpty()) {
			// otherwise topple elements from addStack to removeStack first
			while(!addStack.isEmpty()) {
				removeStack.add(addStack.pop());
			}
			
			removeStack.pop();
			bottomInAdd = 0;
		}

		topInRemove = (!removeStack.isEmpty()) ? removeStack.peek() : 0;
	}
	
	// Peek element from the front
	public int peek() {
		return (topInRemove > 0) ? topInRemove : bottomInAdd;
	}
}