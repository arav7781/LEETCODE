import java.util.*;

class Solution {
    public int findPairs(int[] nums, int k) {
        if (k < 0) return 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int count = 0;
        if (k == 0) {
            for (int freq : map.values()) {
                if (freq > 1) count++;
            }
        } else {
            for (int key : map.keySet()) {
                if (map.containsKey(key + k)) count++;
            }
        }
        return count;
    }
}
