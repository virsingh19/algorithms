package hackerrank;// https://www.hackerrank.com/challenges/encryption/problem?isFullScreen=true
	
public class EncodeString {

    public static void main(String[] args) {
        //String str = "if man was meant to stay on the ground god would have given us roots";
        String str = "feedthedog";
        System.out.println("<" + encryption(str) +">");
    }
    
    static String encryption(String str) {
        str = str.replaceAll("\\s+","");
        
        double sqrt = Math.sqrt(str.length());
        int rows = (int)Math.floor(sqrt);
        int cols = (int)Math.ceil(sqrt);
        
        // Add one to rows if total is less
        if (rows*cols < str.length()) rows++;
        
        char[][] arr = new char[rows][cols];
        
        int rowNum, colNum;
        for (int i= 0; i < str.length(); i++) {
            rowNum = i/cols;
            colNum = i%cols;
            arr[rowNum][colNum] = str.charAt(i);
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < cols; i++) {
            for (int j = 0; j < rows; j++) {
                if ((int)arr[j][i] != 0) {
                    sb.append(arr[j][i]);
                }
            }
            
            if (i < cols-1) {
                // Don't append the last string
                sb.append(" ");
            }
        }
        
        return sb.toString();
    }
}
