package leetcode.problems.p0104;

class MaxDepthBinaryTree {
    int maxDepth(TreeNode treeNode) {
        if (treeNode == null) {
            return 0;
        }

        var leftDepth = maxDepth(treeNode.left);
        var rightDepth = maxDepth(treeNode.right);

        return 1 + Math.max(leftDepth, rightDepth);
    }

    public static void main(String[] args) {
        MaxDepthBinaryTree maxDepthBinaryTree = new MaxDepthBinaryTree();
    }
}
