package hackerrank;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

// https://www.geeksforgeeks.org/estimating-value-pi-using-monte-carlo/
public class MonteCarloValueOfPi {
	static private Map<Float, Boolean> monteCarloMap = new HashMap<>();
	
	public static void main(String[] args) {
		// Create two separate random number generators
		Random randXValues = new Random();
		randXValues.setSeed(0x5DEECE66DL);
		
		Random randYValues = new Random();
		randYValues.setSeed(0xD66ECEED5L);

		long MAX_COUNT = 10000000;
		long circleCount = 0;
		long totalCount = 0;
		float x, y, pi = 0;
		for (long count = 0; count < MAX_COUNT; count++) {
			x = randomFloat(randXValues.nextFloat());
			y = randomFloat(randYValues.nextFloat());
			
			/*float flt = x * 1000000 + y * 1000;
			if (monteCarloMap.containsKey(flt)) {
				continue;
			}
			
			monteCarloMap.put(flt, true); */
			
			totalCount++;
			if ((x*x + y*y) <= 1) {
				circleCount++;
			}
			pi = (float)(4*circleCount)/totalCount;
			System.out.println("Value of pi: " + pi);
		}
		
		System.out.println("Point count: " + totalCount);
	}
	
	// input value is from 0 to < 1
	// what we want the values from 0 to 1 (both inclusive)
	static float randomFloat(float value) {
		if ((value + 0.001) > 1) {
			value = 1;
		}
		return value;
	}
	
/*
	Random random = new Random();
	factor = random.nextDouble();
	num = (int)(((end - start) * factor) + start);
	num = (int)(((end - start) * Math.random()) + start);
	nextFloat()
	setSeed(long)
*/
}
