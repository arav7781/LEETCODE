import java.util.*;

public class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        Map<Integer,Integer> count = new HashMap<>();
        count.put(0,1);
        int sum = 0;
        int res = 0;
        for (int num : nums) {
            sum += num;
            int need = sum - goal;
            res += count.getOrDefault(need, 0);
            count.put(sum, count.getOrDefault(sum, 0) + 1);
        }
        return res;
    }
}
