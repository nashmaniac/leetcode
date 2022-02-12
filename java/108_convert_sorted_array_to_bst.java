class ConvertSortedArrayToBST {

    public TreeNode buildBST(int[] nums, int start, int end) {
        if (start>end) {
            return null;
        }

        int mid = (start+end)/2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = this.buildBST(nums, start, mid-1);
        node.right = this.buildBST(nums, mid+1, end);
        return node;
    }


    public TreeNode sortedArrayToBST(int[] nums) {
        return buildBST(nums, 0, nums.length-1);
    }
}
