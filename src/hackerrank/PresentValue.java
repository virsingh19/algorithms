package hackerrank;

public class PresentValue {
	public static void main(String[] args) {
        int faceValue = 1000;
        double rate = 8.0;
        int term = 4;         // 4 years
        
        
        double pv = 0;
        double sum = 0;
        double coupon = (rate*faceValue)/200;
        int count = 1;
        while (count <= term) {
        	pv = getPresentValue(coupon, rate, count);
        	sum += count*pv;
        	System.out.println("PV: " + pv);
        	count++;
        }
        sum += term*getPresentValue(faceValue, rate, term);
        System.out.println("Sum: " + sum);
	}

	static public double getPresentValue(double faceValue, double rate, int term) {
        double factor = 1 + rate/100;
        factor = Math.pow(factor, term);
        double pv = faceValue/factor;
        
        return pv;
	}

	static public double getFutureValue(double faceValue, double rate, int term) {
        double factor = 1 + rate/100;
        factor = Math.pow(factor, term);
        double pv = faceValue*factor;
        
        return pv;
	}
}
