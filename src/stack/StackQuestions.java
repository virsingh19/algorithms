package stack;
import java.util.Map;
import java.util.SortedMap;
import java.util.Stack;

public class StackQuestions {
	//===========================================================================================
	// Check if the brackets are matching or not
	//===========================================================================================
	public static String checkBrackets2(String s) {
		Stack<Character> stack = new Stack<>();
		Map<Character, Character> pairs = Map.of(
				')', '(',
				'}', '{',
				']', '['
		);

		for (char ch : s.toCharArray()) {
			if (pairs.containsValue(ch)) {
				// opening bracket, push to stack
				stack.push(ch);
			} else if (pairs.containsKey(ch)) {
				// closing bracket, check if it matches the top of the stack
				if (stack.isEmpty() || stack.pop() != pairs.get(ch)) {
					return "NO";
				}
			}
		}

		// if stack is empty, all brackets are matched
		return stack.isEmpty() ? "YES" : "NO";
	}

	//===========================================================================================
	// Maximum of height (sum of stack) should be equal
	//===========================================================================================
	public static void equalStacks() {
		Stack<StackField> stack1 = createStack(new int[] {3, 2, 1, 1, 1});
		Stack<StackField> stack2 = createStack(new int[] {4, 3, 2});
		Stack<StackField> stack3 = createStack(new int[] {1, 1, 4, 1});
			
		while (!stack1.isEmpty() && !stack2.isEmpty() && !stack3.isEmpty()) {
			if (allAreEqual(stack1, stack2, stack3)) {	
				System.out.println("Common Height: " + stack1.peek().getHeight());
				break;
			} else {
				long minHeight = minHeight(stack1, stack2, stack3);
				reduceHeight(stack1, minHeight);
				reduceHeight(stack2, minHeight);
				reduceHeight(stack3, minHeight);
			}
		}
	}
	
	private static Stack<StackField> createStack(int[] values) {
		// last element in the array will be at the bottom of the stack
		Stack<StackField> stack = new Stack<>();
		long height = 0;
		
		for (int i = values.length - 1; i >= 0; i--) {
			height += values[i];
			stack.push(new StackField(values[i], height));
		}

		return stack;
	}
	
	private static boolean allAreEqual(Stack<StackField> stack1, Stack<StackField> stack2, Stack<StackField> stack3) {
        return (stack1.peek().getHeight() == stack2.peek().getHeight()) &&
                stack1.peek().getHeight() == stack3.peek().getHeight();
    }
	
	private static long minHeight(Stack<StackField> stack1, Stack<StackField> stack2, Stack<StackField> stack3) {
		if (stack1.isEmpty() || stack2.isEmpty() || stack3.isEmpty()) {
			return 0;
		}
		
		long minHeight = Math.min(stack1.peek().getHeight(), stack2.peek().getHeight());
		minHeight = Math.min(minHeight, stack3.peek().getHeight());
		
		return minHeight;
	}
	
	private static boolean reduceHeight(Stack<StackField> stack, long height) {
		while (stack != null && !stack.isEmpty()) {
			if (stack.peek().getHeight() > height) {
				stack.pop();
			} else {
				if (stack.peek().getHeight() > height) {
					return true;
				}
				break;
			}
		}
		
		return false;
	}
	
	//===========================================================================================
	// Main method
	//===========================================================================================
	public static void main(String[] args) {
		String s = "{[(}{)]]){(}}(][{{)]{[(((}{}{)}[({[}[}((}{()}[]})]}]]))((]][[{{}[(}})[){()}}{(}{{({{}[[]})]Hello{((]{[){[";
		//System.out.println(checkBrackets(s));
		
		equalStacks();
		
		Stack<Integer> stack = new Stack<>();
		int maxValue = stack.stream().max(Integer::compare).get();
	}
}

class StackField {
	public int value;
	public long Height;
	
    public StackField(int value, long Height) {
		this.value = value;
		this.Height = Height;
	}
    
	public int getValue()   { return value;  }
	public long getHeight() { return Height; }
}