package leetcode.problems.p0112;

import leetcode.util.TreeNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PathSumIterativeTest {

    PathSumIterative pathSum = new PathSumIterative();

    @Test
    public void givenBinaryTree_shouldReturnTrueIfLeafToPathNodeSumExists() {
        TreeNode eleven = new TreeNode(11);
        TreeNode thirteen = new TreeNode(13);
        TreeNode four = new TreeNode(4);

        TreeNode fourParent = new TreeNode(4, eleven, null);
        TreeNode eight = new TreeNode(8, thirteen, four);

        TreeNode node = new TreeNode(5, fourParent, eight);

        boolean result = pathSum.hasPathSum(node, 20);

        assertTrue(result);
    }

}