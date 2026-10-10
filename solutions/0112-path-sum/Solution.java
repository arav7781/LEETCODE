import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
        Deque<TreeNode> nodes = new ArrayDeque<>();
        Deque<Integer> sums = new ArrayDeque<>();
        nodes.push(root);
        sums.push(root.val);

        while (!nodes.isEmpty()) {
            TreeNode node = nodes.pop();
            int sum = sums.pop();
            if (node.left == null && node.right == null && sum == targetSum) {
                return true;
            }
            if (node.right != null) {
                nodes.push(node.right);
                sums.push(sum + node.right.val);
            }
            if (node.left != null) {
                nodes.push(node.left);
                sums.push(sum + node.left.val);
            }
        }
        return false;
    }
}
