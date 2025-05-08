package leetcode.problems.p0111;

import leetcode.util.TreeNode;

class MinDepthBinaryTree {
    int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        // If one child is null, take the depth of the other
        if (root.left == null) {
            return 1 + minDepth(root.right);
        }
        if (root.right == null) {
            return 1 + minDepth(root.left);
        }

        // If both children exist, take just the minimum
        return 1 + Math.min(minDepth(root.left), minDepth(root.right));
    }
}
