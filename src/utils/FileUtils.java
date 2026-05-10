package utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class FileUtils {
	private BufferedReader br = null;
	private FileReader fr = null;
	private BufferedWriter bw = null;
	private FileWriter fw;
	
	public void openReader(String fileName) {
	    try {
			fr = new FileReader(fileName);
			br = new BufferedReader(fr);
		} catch (Exception e) {
			e.printStackTrace();
		}  
	}
	
	public void openWriter(String fileName) {
	    try {
			fw = new FileWriter(fileName);
			bw = new BufferedWriter(fw);
		} catch (Exception e) {
			e.printStackTrace();
		}  
	}
	
	public List<String> readFile() {
		String lineStr = null;
		List<String> list = new LinkedList<>();
		
		while(true) {	
			try {
				lineStr = br.readLine();
				if (lineStr == null) {
					break;
				}
				if (!lineStr.trim().isEmpty()) {
				    list.add(lineStr);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	
	public int[] strLinetoIntArray(String lineStr) {
		int[] intValues = null;
		if (lineStr != null) {
			String[] tokens = lineStr.split(" ");
			intValues = new int[tokens.length];
			for (int i = 0; i < tokens.length; i++) {
				intValues[i] = 0; // initialize it
				try {
				    intValues[i] = Integer.parseInt(tokens[i]);
				} catch(Exception e) {
					e.printStackTrace();
				}
			}
		}
		
		return intValues;
	}

	// Assuming that each line in the file has 2 integer values separated by space
	public int[][] readIntValues() {
		List<String> strList = readFile();
		if (strList == null) {
			return null;
		}
		
		int[][] intValues = new int[strList.size()][2];
		
		for (int i = 0; i < strList.size(); i++) {
			intValues[i][0] = intValues[i][1] = 0;
			int[] values = strLinetoIntArray(strList.get(i));
            System.arraycopy(values, 0, intValues[i], 0, values.length);
		}
		
		return intValues;
	}
	
	public void printIntArray(int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + (i != array.length - 1 ? " " : ""));
		}
		System.out.println("");
	}
	
	public String writeStrLine(String lineStr) {
	    try {
	    	if (lineStr != null) {
			    bw.write(lineStr);
			    bw.newLine();
			    bw.flush();
	    	}
		} catch (IOException e) {
			e.printStackTrace();
		}
	    return lineStr;
	}
	
	public void closeReader() {
		if (fr != null) {
	        try {
				fr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void closeWriter() {
		if (fw != null) {
	        try {
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
