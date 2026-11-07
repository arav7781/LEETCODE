import java.util.*;

class Solution {
    public int beautifulSplits(int[] nums) {
        int n = nums.length;
        if (n < 3) return 0;
        int[][] lcp = new int[n + 1][n + 1];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (nums[i] == nums[j]) {
                    lcp[i][j] = 1 + lcp[i + 1][j + 1];
                } else {
                    lcp[i][j] = 0;
                }
            }
        }
        int count = 0;
        for (int i = 1; i <= n - 2; i++) { // end of nums1
            boolean prefixCondition = lcp[0][i] >= i; // nums1 is prefix of nums2
            for (int j = i + 1; j <= n - 1; j++) { // end of nums2
                int len2 = j - i;
                boolean condition = prefixCondition || lcp[i][j] >= len2;
                if (condition) count++;
            }
        }
        return count;
    }
}
