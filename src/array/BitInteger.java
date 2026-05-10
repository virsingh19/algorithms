package array;


public class BitInteger {
	private final int MAXSIZE = 32;
	private int value;
	private int mask;
	
	public static void main(String[] args) {
		BitInteger bg = new BitInteger(24);
		//bg.setBit(8);
		//bg.shiftLeft(2);
		System.out.println(bg +" "+ bg.size());
		
		bg.clearBit(4);
		System.out.println(bg +" "+ bg.size());
		
		System.out.println("Count: " + bg.cardinality());
		for (int i = 0; i < 5; i++) {
			System.out.println(bg.getBit(i));
		}
	}
	
	public BitInteger(int value) {
		this.value = value;
	}
	
	public int getValue() {
		return value;
	}
	
	public void setValue(int value) {
		this.value = value;
	}
	
	public int getBit(int index) {
		index = index % MAXSIZE;
		mask = 1 << index;
		
		return ((value & mask) > 0) ? 1 : 0;
	}
	
	public void setBit(int index) {
		index = index % MAXSIZE;
		mask = 1 << index;	
		value = value | mask;
	}
	
	public void clearBit(int index) {
		index = index % MAXSIZE;
		mask = 1 << index;
		if ((value & mask) > 0) {
			value = value - mask;
		}
	}
	
	public int shiftLeft(int count) {
		count = count % MAXSIZE;
		value = value << count;
		
		return value;
	}
	
	public int shiftRight(int count) {
		count = count % MAXSIZE;
		value = value >> count;
		
		return value;
	}
	
	public int cardinality() {
		int count = 0;
		int check = value;
		
		while (check > 0) {
			if ((check & 1) > 0) {
			    count++;
			}
			check = check >> 1;
		}
		
		return count;
	}
	
	public int size() {
		int count = 0;
		int check = value;
		
		while (check > 0) {
			count++;
			check = check >> 1;
		}
		
		return count;
	}
	
	public String toString() {
		return Integer.toBinaryString(value);
	}
}
