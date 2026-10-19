import java.util.*;

public class Solution {
    public int maxSubArray(int[] nums) {
        int maxSoFar = nums[0];
        int cur = nums[0];
        for (int i = 1; i < nums.length; i++) {
            cur = Math.max(nums[i], cur + nums[i]);
            maxSoFar = Math.max(maxSoFar, cur);
        }
        return maxSoFar;
    }
}
