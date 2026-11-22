import java.util.*;

public class Solution {
    public long bowlSubarrays(int[] nums) {
        int n = nums.length;
        long visible = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        for (int num : nums) {
            while (!stack.isEmpty() && stack.peekLast() < num) {
                stack.pollLast();
                visible++;
            }
            if (!stack.isEmpty()) {
                visible++;
            }
            stack.addLast(num);
        }
        long result = visible - (n - 1);
        return result > 0 ? result : 0;
    }
}
