# 112. Path Sum

Problem: https://leetcode.com/problems/path-sum/

Difficulty: Easy

AI-generated study solution using Groq `openai/gpt-oss-120b`. Python syntax checked; correctness has not been verified on LeetCode.

We perform a depth‑first search from the root. At each node we subtract its value from the remaining target sum. When we reach a leaf, we check whether the leaf's value exactly matches the remaining sum; if so, a valid root‑to‑leaf path exists. The recursion explores both left and right subtrees, returning True as soon as any subtree yields a matching path. An empty tree cannot contain a path, so we return False immediately.

Time: O(N) where N is the number of nodes, because each node is visited at most once.

Space: O(H) where H is the height of the tree, representing the recursion stack (worst‑case O(N) for a skewed tree).
