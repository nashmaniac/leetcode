class IsValidBSTProblem {
    public boolean isValidBST(TreeNode root, int minValue, int maxValue) {
        if(root == null) {
            return true;
        }

        if(root.val <= minValue || root.val >= maxValue) {
            return false;
        }
        
        return isValidBST(root.left, minValue, root.val) && isValidBST(root.right, root.val, maxValue);
    }
    public boolean isValidBST(TreeNode root) {
        return this.isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
}
