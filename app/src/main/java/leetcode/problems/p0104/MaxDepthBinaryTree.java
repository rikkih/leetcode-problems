package leetcode.problems.p0104;

import leetcode.util.TreeNode;

class MaxDepthBinaryTree {
    int maxDepth(TreeNode treeNode) {
        if (treeNode == null) {
            return 0;
        }

        int leftDepth = maxDepth(treeNode.left);
        int rightDepth = maxDepth(treeNode.right);

        return 1 + Math.max(leftDepth, rightDepth);
    }

    public static void main(String[] args) {
    }
}
