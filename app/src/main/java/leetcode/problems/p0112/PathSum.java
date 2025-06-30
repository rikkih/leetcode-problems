package leetcode.problems.p0112;

import leetcode.util.TreeNode;

public class PathSum {
    boolean hasPathSum(TreeNode root, int targetSum) {
        return dfs(root, targetSum, 0);
    }

    boolean dfs(TreeNode root, int targetSum, int currentSum) {
        if (root == null) {
            return false;
        }

        currentSum += root.val;

        if (isTargetNode(root, targetSum, currentSum)) {
            return true;
        }

        boolean result = dfs(root.left, targetSum, currentSum) || dfs(root.right, targetSum, currentSum);

        return result;
    }

    private boolean isTargetNode(TreeNode node, int targetSum, int currentSum) {
        return currentSum == targetSum && node.left == null && node.right == null;
    }
}
