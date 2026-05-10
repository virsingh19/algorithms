
// Java program to rotate a matrix by 90 degrees, without using any extra space
// below is clockwise rotation, for anti-clockwise rotation, reverse the columns instead of rows in step 2

class RotateMatrix {
    // Driver program to test above functions
    public static void main(String[] args) {
        int size = 4;

        // Test Case 1
        int[][] matrix = {
                { 1, 2, 3, 4 },
                { 5, 6, 7, 8 },
                { 9, 10, 11, 12 },
                { 13, 14, 15, 16 }
        };

        // Test Case 2
        /* int mat[][] = {
               {1, 2, 3},
               {4, 5, 6},
               {7, 8, 9}
           };*/

        // Test Case 3
        /*int mat[][] = {
              {1, 2},
              {4, 5}
          };*/

        displayMatrix(matrix, size);
        transposeMatrix(matrix, size);
        displayMatrix(matrix, size);
        reverseMatrix(matrix, size);
        displayMatrix(matrix, size);
    }

    // Step 1: Transpose the matrix i.e. swap the rows with columns
    static void transposeMatrix(int[][] matrix, int size) {
        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }

    // Step 2: Reverse each row
    static void reverseMatrix(int[][] matrix, int size) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size/2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][size - 1 - j];
                matrix[i][size - 1 - j] = temp;
            }
        }
    }

    // Function to print the matrix
    static void displayMatrix(int[][] matrix, int size) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(" " + matrix[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }
}
