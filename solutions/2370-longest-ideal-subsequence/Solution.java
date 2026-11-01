public class Solution {
    public int longestIdealString(String s, int k) {
        int[] dp = new int[26];
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            int idx = s.charAt(i) - 'a';
            int best = 1;
            int start = Math.max(0, idx - k);
            int end = Math.min(25, idx + k);
            for (int j = start; j <= end; j++) {
                if (dp[j] + 1 > best) {
                    best = dp[j] + 1;
                }
            }
            if (best > dp[idx]) {
                dp[idx] = best;
            }
            if (dp[idx] > result) {
                result = dp[idx];
            }
        }
        return result;
    }
}
