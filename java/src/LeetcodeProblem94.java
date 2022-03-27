import java.util.ArrayList;
import java.util.List;

/***
 * @author shetu2153@gmail.com
 *         Problem: Binary Tree Inorder Traversal
 *         Leetcode Problem Number: 94
 ****/

public class LeetcodeProblem94 {

    public void inOrderTraversal(List<Integer> result, TreeNode root) {
        if (root == null) {
            return;
        }

        inOrderTraversal(result, root.left);
        result.add(root.val);
        inOrderTraversal(result, root.right);
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        // do in-order traversal first
        inOrderTraversal(result, root);
        return result;
    }
}
