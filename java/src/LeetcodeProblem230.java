import java.util.ArrayList;
import java.util.List;

/***
@author shetu2153@gmail.com
Problem: Kth smallest element in BST
Leetcode Problem Number: 230
****/

public class LeetcodeProblem230 {
    public void inOrderTraversal(List<Integer> result, TreeNode root) {
        if (root == null) {
            return;
        }

        inOrderTraversal(result, root.left);
        result.add(root.val);
        inOrderTraversal(result, root.right);
    }
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> result = new ArrayList<>();
        // do in-order traversal first
        inOrderTraversal(result, root);
        // then get the data
        return result.get(k-1);
    }
}
