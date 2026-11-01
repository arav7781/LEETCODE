import java.util.*;

class Solution {
    public TreeNode reverseOddLevels(TreeNode root) {
        if (root == null) return null;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int level = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            List<TreeNode> nodes = new ArrayList<>(size);
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                nodes.add(node);
                if (node.left != null) q.offer(node.left);
                if (node.right != null) q.offer(node.right);
            }
            if (level % 2 == 1) {
                int i = 0, j = nodes.size() - 1;
                while (i < j) {
                    int tmp = nodes.get(i).val;
                    nodes.get(i).val = nodes.get(j).val;
                    nodes.get(j).val = tmp;
                    i++;
                    j--;
                }
            }
            level++;
        }
        return root;
    }
}
