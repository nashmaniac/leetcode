class MinimumBinaryDepthTree {
    
    public int minDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        } else if (root.left == null && root.right != null) {
            return 1+this.minDepth(root.right);
        } else if (root.right == null && root.left != null) {
            return 1+this.minDepth(root.left);
        } else{
            return 1 + Math.max(this.minDepth(root.left), this.minDepth(root.right));
        }
    }    
}
