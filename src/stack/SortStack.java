package stack;

import java.util.Stack;

// Sort a given stack, using another temp stack (can't use any other data structure)
// https://www.geeksforgeeks.org/sort-stack-using-temporary-stack/
public class SortStack {
	public static void main(String args[]) {
		Stack<Integer> input = new Stack<>();
		input.add(34);
		input.add(3);
		input.add(31);
		input.add(98);
		input.add(92);
		input.add(23);

		// This is the temporary stack
		Stack<Integer> tmpStack = sortstack(input);
		System.out.println("Sorted numbers are:");

		while (!tmpStack.empty()) {
			System.out.print(tmpStack.pop() + " ");
		}
	}

	// This function return the sorted stack 
    public static Stack<Integer> sortstack(Stack<Integer> mainStack) { 
        Stack<Integer> tmpStack = new Stack<Integer>();
        while(!mainStack.isEmpty()) {
            // pop out the first element
            int currentValue = mainStack.pop();
          
            // while temporary stack is not empty and
            // top of stack is greater than temp
			while (!tmpStack.isEmpty() && tmpStack.peek() < currentValue) {
				// pop from temporary stack and
				// push it to the input stack
				mainStack.push(tmpStack.pop());
			}
              
            // push temp in temporary of stack
            tmpStack.push(currentValue);
        }
        
        return tmpStack;
    }
}
