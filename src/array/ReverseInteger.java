package array;
public class ReverseInteger {

	public static void main(String[] args) {
		System.out.println("987 -> " + reverseDigits(987));

	}
	
	public static int reverseDigits(int num) {
	    int reversed = 0;
	    int remainder = 0;
	    
	    while (num > 0) {
	    	remainder = num % 10;
	    	reversed = reversed*10 + remainder;
	        num = num/10;
	    }
	    return reversed;
	}
}
