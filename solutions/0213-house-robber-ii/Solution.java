class Solution {
    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        return Math.max(robRange(nums, 0, nums.length - 2),
                        robRange(nums, 1, nums.length - 1));
    }

    private int robRange(int[] nums, int start, int end) {
        int previous = 0;
        int beforePrevious = 0;
        for (int i = start; i <= end; i++) {
            int current = Math.max(previous, beforePrevious + nums[i]);
            beforePrevious = previous;
            previous = current;
        }
        return previous;
    }
}
