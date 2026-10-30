import java.util.*;

class Solution {
    public boolean[] subsequenceSumAfterCapping(int[] nums, int k) {
        int n = nums.length;
        int[] freq = new int[n + 2]; // values up to n
        for (int v : nums) {
            if (v <= n) freq[v]++;
        }
        int[] countGe = new int[n + 2];
        int suffix = 0;
        for (int x = n; x >= 1; x--) {
            suffix += freq[x];
            countGe[x] = suffix;
        }
        boolean[] dp = new boolean[k + 1];
        dp[0] = true;
        boolean[] answer = new boolean[n];
        for (int x = 1; x <= n; x++) {
            int m = countGe[x]; // number of items of weight 1 to add
            if (m > 0) {
                boolean[] newDp = new boolean[k + 1];
                int window = 0;
                for (int s = 0; s <= k; s++) {
                    if (dp[s]) window++;
                    int outIdx = s - m - 1;
                    if (outIdx >= 0 && dp[outIdx]) window--;
                    if (window > 0) newDp[s] = true;
                }
                dp = newDp;
            }
            answer[x - 1] = dp[k];
        }
        return answer;
    }
}
