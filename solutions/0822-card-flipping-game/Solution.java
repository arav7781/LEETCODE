import java.util.*;

public class Solution {
    public int flipgame(int[] fronts, int[] backs) {
        Set<Integer> bad = new HashSet<>();
        int n = fronts.length;
        for (int i = 0; i < n; i++) {
            if (fronts[i] == backs[i]) {
                bad.add(fronts[i]);
            }
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (!bad.contains(fronts[i])) {
                ans = Math.min(ans, fronts[i]);
            }
            if (!bad.contains(backs[i])) {
                ans = Math.min(ans, backs[i]);
            }
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}
