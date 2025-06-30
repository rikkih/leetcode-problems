package leetcode.problems.p0112;

import com.sun.source.tree.Tree;
import leetcode.util.TreeNode;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * Iterative DFS uses a greedy approach for choosing the next node to search.
 * That is, we always want to explore the last node that was placed in our data structure.
 *
 * A perfect candidate for this is a Stack. Stacks are FIFO.
 */
public class PathSumIterative {

    record PathNodeSumCell(TreeNode node, int pathSum) {}

    boolean hasPathSum(TreeNode root, int targetSum) {
        Stack<PathNodeSumCell> stack = new Stack<>();
        stack.push(new PathNodeSumCell(root, root.val));

        int currentSum = 0;

        while (!stack.isEmpty()) {
            PathNodeSumCell current = stack.pop();
            currentSum = current.pathSum;

            if (currentSum == targetSum && current.node.left == null && current.node.right == null) {
                return true;
            }

            TreeNode left = current.node.left;
            TreeNode right = current.node.right;

            if (left != null) {
                stack.push(new PathNodeSumCell(left, currentSum + left.val));
            }
            if (right != null) {
                stack.push(new PathNodeSumCell(right, currentSum + right.val));
            }
        }
        return false;
    }
}
