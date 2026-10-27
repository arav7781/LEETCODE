import java.util.*;

class Solution {
    public int numberOfGoodSubarraySplits(int[] nums) {
        final long MOD = 1_000_000_007L;
        List<Integer> ones = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                ones.add(i);
            }
        }
        int k = ones.size();
        if (k == 0) return 0;
        long ans = 1;
        for (int i = 1; i < k; i++) {
            int gap = ones.get(i) - ones.get(i - 1) - 1;
            ans = ans * (gap + 1) % MOD;
        }
        return (int) ans;
    }
}
