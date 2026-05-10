package hackerrank;
public class LogValue {
	public static void main(String[] args) {
		double value = 10;
        double out = Math.log(value);
        System.out.println("Result e base: " + out);
        System.out.println("Result 2 base: " + log(value,2));
	}
	
	static double log(double x, double base) {
	    return Math.log(x) / Math.log(base);
	}
}
