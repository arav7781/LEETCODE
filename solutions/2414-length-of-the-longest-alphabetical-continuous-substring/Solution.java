public class Solution {
    public int longestContinuousSubstring(String s) {
        if (s == null || s.length() == 0) return 0;
        int max = 1;
        int cur = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) - s.charAt(i - 1) == 1) {
                cur++;
            } else {
                cur = 1;
            }
            if (cur > max) max = cur;
        }
        return max;
    }
}
