package leetcode.problems.p0104;

import leetcode.util.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

class MaxDepthBinaryTree2 {

    int maxDepthRecursive(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftDepth = maxDepthRecursive(root.left);
        int rightDepth = maxDepthRecursive(root.right);

        return 1 + Math.max(leftDepth, rightDepth);
    }

    int maxDepthIterative(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 0;

        while(!queue.isEmpty()) {
            int levelSize = queue.size();

            for (int i = 0; i < levelSize; i++) {
                TreeNode current = queue.poll();
                if (current.left != null) {
                    queue.offer(current.left);
                }

                if (current.right != null) {
                    queue.offer(current.right);
                }
            }
            depth++;
        }
        return depth;
    }

    public static void main(String[] args) {
        TreeNode testCase = TreeNode.createExampleTree();

        MaxDepthBinaryTree2 maxDepthBinaryTree2 = new MaxDepthBinaryTree2();
        var result = maxDepthBinaryTree2.maxDepthIterative(testCase);

        System.out.println(result);
    }
}
