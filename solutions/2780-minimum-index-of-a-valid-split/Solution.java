import java.util.*;

class Solution {
    public int minimumIndex(List<Integer> nums) {
        int n = nums.size();
        if (n < 2) return -1;
        // Find dominant candidate using Boyer-Moore
        int candidate = 0;
        int cnt = 0;
        for (int v : nums) {
            if (cnt == 0) {
                candidate = v;
                cnt = 1;
            } else if (v == candidate) {
                cnt++;
            } else {
                cnt--;
            }
        }
        // Count total occurrences of candidate
        int total = 0;
        for (int v : nums) {
            if (v == candidate) total++;
        }
        // Verify candidate is indeed dominant (problem guarantees it)
        int leftCount = 0;
        for (int i = 0; i < n - 1; i++) {
            if (nums.get(i) == candidate) leftCount++;
            int leftLen = i + 1;
            int rightLen = n - leftLen;
            int rightCount = total - leftCount;
            if (leftCount * 2 > leftLen && rightCount * 2 > rightLen) {
                return i;
            }
        }
        return -1;
    }
}
