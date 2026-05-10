package hackerrank;

public class Fibonacci {
	public static void main(String[] args) {
		int n = 4;
		System.out.println(n +": "+ fibonacci(n));

	}

	// 0, 1, 1, 2, 3, 5, 8
	public static int fibonacci(int n) {
		if (n < 0) {
			return -1;
		} else if (n == 0 || n == 1) {
			return n;
		}
		
		int n1 = 0, n2 = 1;
		int value = n1 + n2;

		for (int i = 2; i < n; i++) { 
			value = n1 + n2;
			n1 = n2;
			n2 = value;
		}
		
		return value;
	}
}
