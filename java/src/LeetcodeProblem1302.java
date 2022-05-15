public class LeetcodeProblem1302 {
    int sum = 0;
    
    public int findHeight(TreeNode root) {
        if(root == null) {
            return 0;
        }
        
        return 1 + Math.max(findHeight(root.left), findHeight(root.right));
    }
    
    public void findSum(TreeNode root, int level, int height) {
        if (root == null) {
            return;
        }
        
        if(level == height) {
            sum += root.val;
        }
        
        findSum(root.left, level+1, height);
        findSum(root.right, level+1, height);
    }
    
    public int deepestLeavesSum(TreeNode root) {
        
        int h = findHeight(root);
        findSum(root, 1, h);
        return sum;
        
    }
}
