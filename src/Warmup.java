public class Warmup {
	
	private static void charCount() {
		String str = "aba";
		int totalLen = 10;
		
		int len = str.length();
		int times = totalLen/len;
		int partialLen = totalLen % len;
		
		long count = str.chars().filter(ch -> ch == 'a').count();
		long partial = str.substring(0, partialLen).chars().filter(ch -> ch == 'a').count();
		
		System.out.println("Count: "+ (count*times + partial));
	}

	/*
	You are given an array of clouds:
		0 = safe cloud
		1 = thundercloud (cannot land)
	You start at index 0 and need to reach the last cloud.

	You can jump:
		1 cloud ahead
		2 clouds ahead
	Find the minimum number of jumps needed.
	 */
	public static int cloudJump() {
		final int SAFE = 0;
		//int[] clouds = {0, 1, 0, 0, 0, 1, 0};
		//int[] clouds = {0, 0, 1, 0, 0, 1, 0};
		int[] clouds = {0, 0, 1, 0, 0, 1, 1}; // this should fail

		int jumpCount = 0;
		int curStep = 0;

		// Keep jumping till at least we are at the second last cloud
		while (curStep < clouds.length - 1) {
			// Prefer 2-step jump if possible, otherwise take 1 step
			if (curStep + 2 < clouds.length && clouds[curStep + 2] == SAFE) {
				curStep += 2;
			} else {
				// is next step safe?
				if (clouds[curStep + 1] != SAFE) {
					System.out.println("No safe path available!");
					break;
				}
				curStep += 1;
			}

			jumpCount++;
		}

		System.out.println("Jumps: " + jumpCount);

		return jumpCount;
	}
	

	public static void main(String[] args) {
		//charCount();
		/*String str = "atom";
		System.out.println(str.codePointAt(0));
		System.out.println(str.charAt(0));
		System.out.println(str.contains("to"));*/

		cloudJump();
	}
}
