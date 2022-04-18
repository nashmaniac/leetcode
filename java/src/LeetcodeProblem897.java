import java.util.ArrayList;


public class LeetcodeProblem897 {

    ArrayList<TreeNode> result = new ArrayList<>();
    public TreeNode increasingBST(TreeNode root) {
        increasingBST(root, result);
        TreeNode cur = new TreeNode(-1);
        TreeNode ans = cur;

        for(TreeNode t: result) {
            cur.right = new TreeNode(t.val);
            cur = cur.right;
        }

        return ans.right;
    }

    public TreeNode increasingBST(TreeNode root, ArrayList<TreeNode> result) {
        if(root == null) {
            return null;
        }
        increasingBST(root.left, result);
        if(root != null) {
            result.add(root);
        }
        increasingBST(root.right, result);
        return root;
    }
}
