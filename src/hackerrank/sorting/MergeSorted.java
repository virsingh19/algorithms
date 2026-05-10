package hackerrank.sorting;

import java.util.ArrayList;

public class MergeSorted {
    public static void main(String[] args) {
        int[] arr1 = {-1 , 2 , 3 , 7 , 8, 10 };
        int[] arr2 = {-4 , -1 , 3 , 6 , 9, 13};

        ArrayList<Integer> outList = new ArrayList<>();
        int start1 = 0;
        int start2 = 0;

        while ((start1 < arr1.length) || (start2 < arr2.length)) {
            if (start1 >= arr1.length) {
                // copy remaining arr2
                outList.add(arr2[start2]);
                start2++;
            } else if (start2 >= arr2.length) {
                // copy remaining arr1
                outList.add(arr1[start1]);
                start1++;
            } else if (arr1[start1] <= arr2[start2]) {
                //copy from arr1
                outList.add(arr1[start1]);
                start1++;
            } else {
                //copy from arr2
                outList.add(arr2[start2]);
                start2++;
            }
        }

        System.out.println("Final: " + outList);
    }
}

