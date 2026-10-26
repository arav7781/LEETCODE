import java.util.*;

public class Solution {
    public long beautifulSubarrays(int[] nums) {
        Map<Integer, Long> freq = new HashMap<>();
        int prefix = 0;
        long ans = 0L;
        freq.put(0, 1L);
        for (int num : nums) {
            prefix ^= num;
            Long cnt = freq.get(prefix);
            if (cnt != null) {
                ans += cnt;
                freq.put(prefix, cnt + 1);
            } else {
                freq.put(prefix, 1L);
            }
        }
        return ans;
    }
}
