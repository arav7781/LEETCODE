import java.util.*;

class Solution {
    public long countDistinct(long n) {
        String s = Long.toString(n);
        int len = s.length();
        Long[][][] memo = new Long[len + 1][2][2];
        return dfs(0, true, false, s, memo);
    }

    private long dfs(int idx, boolean tight, boolean started, String s, Long[][][] memo) {
        if (idx == s.length()) {
            return started ? 1L : 0L; // count only positive numbers
        }
        int t = tight ? 1 : 0;
        int st = started ? 1 : 0;
        if (memo[idx][t][st] != null) {
            return memo[idx][t][st];
        }
        int limit = tight ? s.charAt(idx) - '0' : 9;
        long res = 0L;
        for (int d = 0; d <= limit; d++) {
            boolean nextTight = tight && (d == limit);
            boolean nextStarted = started || d != 0;
            if (!nextStarted) {
                // still leading zeros, allowed
                res += dfs(idx + 1, nextTight, false, s, memo);
            } else {
                if (d == 0) continue; // zero not allowed after number has started
                res += dfs(idx + 1, nextTight, true, s, memo);
            }
        }
        memo[idx][t][st] = res;
        return res;
    }
}
