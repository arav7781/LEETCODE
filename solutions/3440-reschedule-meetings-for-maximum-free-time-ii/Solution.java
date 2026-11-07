import java.util.*;

class Solution {
    private static class Pair {
        int max1;
        int cnt1;
        int max2;
        Pair(int max1, int cnt1, int max2) {
            this.max1 = max1;
            this.cnt1 = cnt1;
            this.max2 = max2;
        }
    }

    private Pair combine(Pair a, Pair b) {
        int max1 = -1, cnt1 = 0, max2 = -1;
        // helper to add a value with count
        java.util.function.BiConsumer<Integer, Integer> add = (val, cnt) -> {
            if (val < 0) return;
            if (val > max1) {
                max2 = max1;
                max1 = val;
                cnt1 = cnt;
            } else if (val == max1) {
                cnt1 += cnt;
            } else if (val > max2) {
                max2 = val;
            }
        };
        add.accept(a.max1, a.cnt1);
        add.accept(b.max1, b.cnt1);
        add.accept(a.max2, 1);
        add.accept(b.max2, 1);
        return new Pair(max1, cnt1, max2);
    }

    public int maxFreeTime(int eventTime, int[] startTime, int[] endTime) {
        int n = startTime.length;
        int[] gaps = new int[n + 1];
        gaps[0] = startTime[0];
        for (int i = 1; i < n; i++) {
            gaps[i] = startTime[i] - endTime[i - 1];
        }
        gaps[n] = eventTime - endTime[n - 1];
        int originalMax = 0;
        for (int g : gaps) originalMax = Math.max(originalMax, g);
        // prefix pairs
        Pair[] pref = new Pair[n + 1];
        pref[0] = new Pair(gaps[0], 1, -1);
        for (int i = 1; i <= n; i++) {
            Pair single = new Pair(gaps[i], 1, -1);
            pref[i] = combine(pref[i - 1], single);
        }
        // suffix pairs
        Pair[] suff = new Pair[n + 2]; // extra for ease
        suff[n] = new Pair(gaps[n], 1, -1);
        for (int i = n - 1; i >= 0; i--) {
            Pair single = new Pair(gaps[i], 1, -1);
            suff[i] = combine(single, suff[i + 1]);
        }
        int best = originalMax;
        for (int i = 0; i < n; i++) {
            int d = endTime[i] - startTime[i];
            int L = gaps[i];
            int R = gaps[i + 1];
            int merged = L + d + R;
            // remaining gaps after removing gap i and i+1
            Pair left = (i - 1 >= 0) ? pref[i - 1] : new Pair(-1, 0, -1);
            Pair right = (i + 2 <= n) ? suff[i + 2] : new Pair(-1, 0, -1);
            Pair rem = combine(left, right);
            // overall max and second max after adding merged gap
            int overallMax, overallCnt, secondMax;
            if (merged > rem.max1) {
                overallMax = merged;
                overallCnt = 1;
                secondMax = rem.max1;
            } else if (merged == rem.max1) {
                overallMax = merged;
                overallCnt = rem.cnt1 + 1;
                secondMax = rem.max2;
            } else { // merged < rem.max1
                overallMax = rem.max1;
                overallCnt = rem.cnt1;
                secondMax = Math.max(rem.max2, merged);
            }
            // option A: insert into a gap that is not the unique max
            boolean feasibleA = false;
            if (overallCnt >= 2) {
                if (overallMax >= d) feasibleA = true;
            } else { // unique max
                if (merged != overallMax && merged >= d) feasibleA = true;
                else if (rem.max2 >= d) feasibleA = true;
            }
            int curBest = originalMax;
            if (feasibleA) {
                curBest = Math.max(curBest, overallMax);
            }
            // option B: insert into the unique max gap (if possible)
            if (overallMax >= d) {
                int candidate = Math.max(overallMax - d, secondMax);
                curBest = Math.max(curBest, candidate);
            }
            best = Math.max(best, curBest);
        }
        return best;
    }
}
