package leetcode.problems.p0112;

import leetcode.util.TreeNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PathSumTest {

    private PathSum pathSum = new PathSum();

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

    @Test
    public void givenBinaryTree_shouldReturnTrueIfLeafToPathNodeSumExists12() {
        TreeNode two = new TreeNode(2);
        TreeNode node = new TreeNode(1, two, null);

        boolean result = pathSum.hasPathSum(node, 1);

        assertTrue(result);
    }
}