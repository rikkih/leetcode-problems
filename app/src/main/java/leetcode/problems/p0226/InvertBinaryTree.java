package leetcode.problems.p0226;

import java.util.LinkedList;
import java.util.Queue;

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

    TreeNode invertIterative(TreeNode root) {
        if (root == null) {
            return null;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();

            TreeNode temp = current.left;
            current.left = current.right;
            current.right = temp;

            if (current.left != null) {
                queue.offer(current.left);
            }
            if (current.right != null) {
                queue.offer(current.right);
            }
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode testCase = TreeNode.createExampleTree();
        InvertBinaryTree invertBinaryTree = new InvertBinaryTree();

        var inverted = invertBinaryTree.invertIterative(testCase);
        System.err.println(inverted);
    }
}
