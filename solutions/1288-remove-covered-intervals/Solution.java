import java.util.Arrays;

public class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            if (a[0] != b[0]) return Integer.compare(a[0], b[0]);
            return Integer.compare(b[1], a[1]);
        });
        int count = 0;
        int maxEnd = -1;
        for (int[] iv : intervals) {
            if (iv[1] > maxEnd) {
                count++;
                maxEnd = iv[1];
            }
        }
        return count;
    }
}
