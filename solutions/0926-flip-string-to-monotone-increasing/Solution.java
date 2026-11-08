public class Solution {
    public int minFlipsMonoIncr(String s) {
        int flips = 0;
        int ones = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '1') {
                ones++;
            } else {
                if (ones > 0) {
                    flips++;
                }
                if (flips > ones) {
                    flips = ones;
                }
            }
        }
        return flips;
    }
}
