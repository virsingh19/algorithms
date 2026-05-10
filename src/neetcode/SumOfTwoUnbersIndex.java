package neetcode;

import java.util.HashMap;
import java.util.Map;

public class SumOfTwoUnbersIndex {
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;

        int[] result = twoSum(nums, target);
        System.out.println("[" + result[0] + ", " + result[1] + "]");
    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>(); // value → index

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            if (map.containsKey(complement)) {
                int j = map.get(complement);
                return j < i ? new int[]{j, i} : new int[]{i, j};
            }

            // Keep adding the numbers to the map
            map.put(nums[i], i);
        }

        // Problem guarantees exactly one solution
        return new int[]{-1, -1};
    }
}
