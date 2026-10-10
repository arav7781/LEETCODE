# AI-generated study solution; review before use.
class Solution:
    def rob(self, nums: list[int]) -> int:
        """Return the maximum amount that can be robbed without alerting police.
        The houses form a circle, so the first and last houses are adjacent.
        We solve the classic linear House Robber problem twice:
        1. Rob houses in the range [0, n-2] (exclude last).
        2. Rob houses in the range [1, n-1] (exclude first).
        The answer is the maximum of the two results.
        Edge cases:
        * n == 1 → return nums[0]
        * n == 2 → return max(nums)
        """
        n = len(nums)
        if n == 0:
            return 0
        if n == 1:
            return nums[0]
        if n == 2:
            return max(nums[0], nums[1])

        def rob_linear(arr: list[int]) -> int:
            """Standard linear house robber DP with O(1) space.
            prev1 = max loot up to previous house, prev2 = max loot up to house before previous.
            """
            prev2, prev1 = 0, 0
            for amount in arr:
                cur = max(prev1, prev2 + amount)
                prev2, prev1 = prev1, cur
            return prev1

        # Exclude last house
        loot1 = rob_linear(nums[:-1])
        # Exclude first house
        loot2 = rob_linear(nums[1:])
        return max(loot1, loot2)

