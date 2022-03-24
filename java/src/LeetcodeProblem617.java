public class LeetcodeProblem617 {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return null;
        } else if (root1 == null && root2 != null) {
            return root2;
        } else if (root1 != null && root2 == null) {
            return root1;
        } else {
            TreeNode node = new TreeNode(root1.val + root2.val);

            node.left = this.mergeTrees(root1.left, root2.left);
            node.right = this.mergeTrees(root1.right, root2.right);

            return node;
        }
    }
}
