class MaximumDepthOfBinaryTree {
    public int maxDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }

        return 1 + Math.max(this.maxDepth(root.left), this.maxDepth(root.right));
    }
}
