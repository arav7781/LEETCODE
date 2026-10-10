# AI-generated study solution; review before use.
from typing import Optional

# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val: int = 0, left: Optional['TreeNode'] = None, right: Optional['TreeNode'] = None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def hasPathSum(self, root: Optional[TreeNode], targetSum: int) -> bool:
        """Return True if there exists a root‑to‑leaf path whose values sum to targetSum."""
        if not root:
            return False
        # If we are at a leaf, the path sum must equal the remaining target.
        if not root.left and not root.right:
            return root.val == targetSum
        # Reduce the target by the current node's value and recurse.
        remaining = targetSum - root.val
        return (self.hasPathSum(root.left, remaining) or
                self.hasPathSum(root.right, remaining))

