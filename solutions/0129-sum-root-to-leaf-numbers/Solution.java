import java.util.*;

public class Solution {
    public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }
    private int dfs(TreeNode node, int cur) {
        if (node == null) return 0;
        int newVal = cur * 10 + node.val;
        if (node.left == null && node.right == null) {
            return newVal;
        }
        return dfs(node.left, newVal) + dfs(node.right, newVal);
    }
}
