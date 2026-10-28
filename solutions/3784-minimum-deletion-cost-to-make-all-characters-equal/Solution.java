public class Solution {
    public long minCost(String s, int[] cost) {
        long total = 0;
        long[] sum = new long[26];
        for (int i = 0; i < s.length(); i++) {
            int idx = s.charAt(i) - 'a';
            long c = cost[i];
            total += c;
            sum[idx] += c;
        }
        long max = 0;
        for (long v : sum) {
            if (v > max) max = v;
        }
        return total - max;
    }
}
