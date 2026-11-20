import java.util.*;

class Solution {
    public long numberOfSubsequences(int[] nums) {
        int n = nums.length;
        int maxVal = 1000;
        int[][] pref = new int[n][maxVal + 1];
        for (int i = 0; i < n; i++) {
            if (i > 0) System.arraycopy(pref[i - 1], 0, pref[i], 0, maxVal + 1);
            pref[i][nums[i]]++;
        }
        int[][] suff = new int[n][maxVal + 1];
        for (int i = n - 1; i >= 0; i--) {
            if (i < n - 1) System.arraycopy(suff[i + 1], 0, suff[i], 0, maxVal + 1);
            suff[i][nums[i]]++;
        }
        long ans = 0L;
        for (int q = 1; q <= n - 4; q++) {
            int leftIdx = q - 2;
            if (leftIdx < 0) continue;
            int b = nums[q];
            for (int r = q + 2; r <= n - 2; r++) {
                int c = nums[r];
                int rightIdx = r + 2;
                if (rightIdx >= n) continue;
                for (int a = 1; a <= maxVal; a++) {
                    int leftCount = pref[leftIdx][a];
                    if (leftCount == 0) continue;
                    long prod = (long) a * c;
                    if (prod % b != 0) continue;
                    int d = (int) (prod / b);
                    if (d < 1 || d > maxVal) continue;
                    int rightCount = suff[rightIdx][d];
                    if (rightCount == 0) continue;
                    ans += (long) leftCount * rightCount;
                }
            }
        }
        return ans;
    }
}
