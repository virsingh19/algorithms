package hackerrank;

public class BinarySearch {
	int count = 0;
	
	public static void main(String[] args) {
        int arr[] = {
        	3, 5, 6, 8, 10, 17, 18, 25, 28,
        	33, 45, 67, 72, 88, 89, 93, 114, 130, 144
        };
        
        BinarySearch bs = new BinarySearch();
        bs.printArray(arr);
        int values[] = {1, 3, 10, 14, 88, 144, 166};
        
        for (int i = 0; i < values.length; i++) {
            System.out.println("Result: [" + bs.search(arr, values[i]) +"]:" + values[i] +", count " + bs.count);
        }
	}
	
	public int search(int arr[], int num) {
		if (arr == null || arr.length < 1) {
			return -1;
		}
		
		int min = 0;
		int max = arr.length - 1;
		int pos = 0;
		
		count = 0;
		while (min <= max) {
			count++;
			
			pos = (min + max)/2;
			if (arr[pos] == num) {
				return pos;
			}
			
			if (arr[pos] > num) {
                max = pos - 1;
			} else {
				min = pos + 1;
			}
		}
		
		return -1;
	}
	
	private void printArray(int arr[]) {
		System.out.print("Array[" + arr.length + "] = {");
		for (int i = 0; i < arr.length; i++) {
			System.out.print("[" + i +"]:" + arr[i] +", ");
		}
		System.out.println("}");
	}
}


