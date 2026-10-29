public class Solution {
    public boolean circularArrayLoop(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) continue;
            boolean forward = nums[i] > 0;
            int slow = i, fast = i;
            while (true) {
                slow = nextIndex(nums, slow, n);
                if (slow == -1 || forward != (nums[slow] > 0)) break;
                fast = nextIndex(nums, fast, n);
                if (fast == -1 || forward != (nums[fast] > 0)) break;
                fast = nextIndex(nums, fast, n);
                if (fast == -1 || forward != (nums[fast] > 0)) break;
                if (slow == fast) return true;
            }
            int j = i;
            while (true) {
                if (nums[j] == 0) break;
                boolean dir = nums[j] > 0;
                if (dir != forward) break;
                int next = nextIndex(nums, j, n);
                nums[j] = 0;
                if (next == -1) break;
                j = next;
            }
        }
        return false;
    }

    private int nextIndex(int[] nums, int current, int n) {
        int move = nums[current];
        int next = ((current + move) % n + n) % n;
        if (next == current) return -1;
        return next;
    }
}
