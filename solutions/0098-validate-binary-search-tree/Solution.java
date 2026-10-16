import java.util.*;

class Solution {
    public boolean isValidBST(TreeNode root) {
        return validate(root, null, null);
    }
    private boolean validate(TreeNode node, Long lower, Long upper) {
        if (node == null) return true;
        long val = node.val;
        if (lower != null && val <= lower) return false;
        if (upper != null && val >= upper) return false;
        if (!validate(node.right, val, upper)) return false;
        if (!validate(node.left, lower, val)) return false;
        return true;
    }
}
