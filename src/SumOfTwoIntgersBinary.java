public class SumOfTwoIntgersBinary {
	public static void main(String[] args) {
		int a = 28, b = 15;
		System.out.printf("a: (%d) - %16s\n", a, Integer.toBinaryString(a));
		System.out.printf("b: (%d) - %16s\n", b, Integer.toBinaryString(b));
		System.out.println("Add: " + add(a, b));
	}

	// Function to add two numbers without using arithmetic operators
	public static int add(int a, int b) {
		// Iterate till b is not fully added to a
		while (b != 0) {
			// Sum bits where at least one bit is not set (sum without carry)
			a = a ^ b;
			printBinary("Loop - a", a);

			// Find common set bits that will cause a carry
			int carry = a & b;
			printBinary("Loop - c", carry);

			// Carry is shifted by one so it can be added in next iteration
			b = carry << 1;
			printBinary("Loop - b", b);
		}
		return a;
	}
	
	static void printBinary(String desc, int value) {
		System.out.printf(desc + ": (%d) - %16s\n", value, Integer.toBinaryString(value));
	}
}
