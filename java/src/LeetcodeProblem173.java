import java.util.Stack;

public class LeetcodeProblem173 {
    class BSTIterator {

        Stack<TreeNode> stack;
        public BSTIterator(TreeNode root) {
            stack = new Stack<>();
            putToStack(root);
        }

        public void putToStack(TreeNode root) {
            TreeNode cur = root;
            while(cur != null) {
                this.stack.push(cur);
                cur = cur.left;
            }
        }
        
        public int next() {
            TreeNode top = this.stack.pop();
            if(top.right != null) {
                putToStack(top.right);
            }
            return top.val;
        }
        
        public boolean hasNext() {
            return !this.stack.isEmpty();
        }
    }
}
