package leetcode.problems.p0226;

import leetcode.util.TreeNode;

class InvertBinaryTree {
    TreeNode invertRecursiveInPlace(TreeNode root) {
        if (root == null) {
            return root;
        }

        invertRecursiveInPlace(root.left);
        invertRecursiveInPlace(root.right);

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        return root;
    }

    TreeNode invertRecursive(TreeNode root) {
        if (root == null) {
            return root;
        }

        TreeNode left = invertRecursive(root.left);
        TreeNode right = invertRecursive(root.right);
        root.left = right;
        root.right = left;

        return root;
    }
}
