import java.util.*;

class Solution {
    public int minTime(String s, int[] order, int k) {
        int n = s.length();
        long total = (long) n * (n + 1) / 2;
        if (k > total) return -1;
        long sumBlock = total;
        TreeSet<Integer> stars = new TreeSet<>();
        stars.add(-1);
        stars.add(n);
        for (int t = 0; t < n; t++) {
            int p = order[t];
            Integer left = stars.lower(p);
            Integer right = stars.higher(p);
            long L = right - left - 1;
            long a = p - left - 1;
            long b = right - p - 1;
            long before = L * (L + 1) / 2;
            long after = a * (a + 1) / 2 + b * (b + 1) / 2;
            sumBlock -= (before - after);
            stars.add(p);
            if (total - sumBlock >= k) return t;
        }
        return -1;
    }
}
