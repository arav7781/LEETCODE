import java.util.*;

class Solution {
    public int maxBalancedShipments(int[] weight) {
        int n = weight.length;
        int[] dp = new int[n];
        int[] prevGreater = new int[n];
        Arrays.fill(prevGreater, -1);
        Deque<Integer> stack = new ArrayDeque<>(); // decreasing stack
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && weight[stack.peek()] <= weight[i]) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                prevGreater[i] = stack.peek();
            }
            stack.push(i);
        }
        for (int i = 0; i < n; i++) {
            int best = (i == 0) ? 0 : dp[i - 1];
            int pg = prevGreater[i];
            if (pg != -1) {
                int before = (pg == 0) ? 0 : dp[pg - 1];
                best = Math.max(best, before + 1);
            }
            dp[i] = best;
        }
        return dp[n - 1];
    }
}
