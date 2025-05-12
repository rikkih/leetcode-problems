package leetcode.problems.p0104;

import java.util.Stack;

import leetcode.util.TreeNode;

class MaxDepthBinaryTree {
    int maxDepthRecursive(TreeNode treeNode) {
        if (treeNode == null) {
            return 0;
        }

        int leftDepth = maxDepthRecursive(treeNode.left);
        int rightDepth = maxDepthRecursive(treeNode.right);

        return 1 + Math.max(leftDepth, rightDepth);
    }

    int maxDepthIterative(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int maxDepth = 0;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {

        }

        return -1;
    }

    public static void main(String[] args) {
    }
}
