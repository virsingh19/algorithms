package neetcode;

import java.util.*;

public class TopFrequentElements {
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;

        System.out.println(Arrays.toString(topKFrequent(nums, k)));
    }

    public static int[] topKFrequent(int[] nums, int k) {
        // We need a HashSet to see if the number is already processed
        // TreeMap where the frequency is the key and the list of numbers as values
        TreeMap<Integer, List<Integer>> treeMap = getIntegerListTreeMap(nums);

        // Allocate an array to hold the top k frequent elements
        int[] result = new int[k];
        int index = 0;
        for (List<Integer> list: treeMap.values()) {
            for (int num : list) {
                result[index++] = num;
                if (index == k) {
                    return result;
                }
            }
        }

        return result;
    }

    private static TreeMap<Integer, List<Integer>> getIntegerListTreeMap(int[] nums) {
        Set<Integer> set = new HashSet<>();
        TreeMap<Integer, List<Integer>> treeMap = new TreeMap<>(Collections.reverseOrder());

        // Step 1: Count frequency
        for (int num : nums) {
            if (!set.contains(num)) {
                // find the frequency count
                int count = countFrequency(nums, num);

                // Add this to the map
                List<Integer> list;
                if (treeMap.containsKey(count)) {
                    list = treeMap.get(count);
                } else {
                    list = new LinkedList<>();
                    treeMap.put(count, list);
                }

                list.add(num);
                set.add(num);
            }
        }
        return treeMap;
    }

    private static int countFrequency(int[] nums, int target) {
        int count = 0;
        for (int num : nums) {
            if (num == target) {
                count++;
            }
        }
        return count;
    }
}
