public class Solution {
    public long getDescentPeriods(int[] prices) {
        long total = 0;
        long cnt = 1;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i - 1] - prices[i] == 1) {
                cnt++;
            } else {
                total += cnt * (cnt + 1) / 2;
                cnt = 1;
            }
        }
        total += cnt * (cnt + 1) / 2;
        return total;
    }
}
