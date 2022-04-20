public class LeetcodeProblem99 {

    public void swap(TreeNode t1, TreeNode t2) {
        int t = t1.val;
        t1.val = t2.val;
        t2.val = t;
    }

    TreeNode first, middle, second = null;
    TreeNode prevNode = null;

    public void inOrderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrderTraversal(root.left);

        if (prevNode != null && prevNode.val > root.val) {
            if (first != null && middle != null) {
                second = root;
            } else {
                first = prevNode;
                middle = root;
            }

        }
        prevNode = root;
        inOrderTraversal(root.right);
    }

    public void recoverTree(TreeNode root) {
        inOrderTraversal(root);
        if(second == null) {
            swap(first, middle);
        } else {
            swap(first, second);
        }
    }

    public static void main(String[] args) {
        Integer[] nums = new Integer[] {
                3, 1, 4, null, null, 2
        };

        TreeNode root = TreeNode.constructTree(nums);

        LeetcodeProblem99 l = new LeetcodeProblem99();
        l.recoverTree(root);
    }
}
