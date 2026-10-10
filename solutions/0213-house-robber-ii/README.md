# 213. House Robber II

Problem: https://leetcode.com/problems/house-robber-ii/

Difficulty: Medium

AI-generated study solution using Groq `openai/gpt-oss-120b`. Python syntax checked; correctness has not been verified on LeetCode.

We reduce the circular arrangement to two linear sub‑problems because the first and last houses cannot both be chosen. For a linear street the optimal robbery amount can be computed with a simple DP: for each house we decide to either skip it (keep the previous maximum) or rob it (add its money to the maximum two houses back). Maintaining only two variables (prev1 and prev2) gives O(1) extra space. The final answer is the larger of the two linear solutions – one that excludes the last house and one that excludes the first. Edge cases of length 1 or 2 are handled directly.

Time: O(n) where n is the number of houses, because we traverse the array a constant number of times.

Space: O(1) extra space, only a few integer variables are used regardless of input size.
