import java.util.*;

public class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int[] dp = new int[n];
        System.arraycopy(matrix[0], 0, dp, 0, n);
        for (int i = 1; i < n; i++) {
            int[] newDp = new int[n];
            for (int j = 0; j < n; j++) {
                int minPrev = dp[j];
                if (j > 0) minPrev = Math.min(minPrev, dp[j - 1]);
                if (j < n - 1) minPrev = Math.min(minPrev, dp[j + 1]);
                newDp[j] = matrix[i][j] + minPrev;
            }
            dp = newDp;
        }
        int ans = dp[0];
        for (int v : dp) {
            if (v < ans) ans = v;
        }
        return ans;
    }
}
