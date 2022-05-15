import java.util.LinkedList;
import java.util.Queue;

class TreePrinter {
    public static int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(getHeight(root.left), getHeight(root.right));
    }

    public static void printTree(TreeNode node) {
        int SPACE = 2;
        int level = 0;
        int nodePrintLocation = 0;
        int height = getHeight(node);
        // System.out.print(height);

        TreeNode dummy = new TreeNode(Integer.MIN_VALUE);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(node);
        queue.offer(null);

        while (!queue.isEmpty()) {
            node = queue.remove();
            if (node == null) {
                if (!queue.isEmpty()) {
                    queue.add(null);
                }
                System.out.println();
                level++;
            } else {
                nodePrintLocation = ((int)Math.pow(2f, (height - level))) * SPACE;
                System.out.print(getPrintLine(node, nodePrintLocation));
                if (level < height) {
                    queue.add((node.left != null) ? node.left : dummy);
                    queue.add((node.right != null) ? node.right : dummy);
                }
            }
        }
    }

    public static String getPrintLine(TreeNode node, int spaces) {
        StringBuilder sb = new StringBuilder();
        if (node.val == Integer.MIN_VALUE) {
            for (int i = 0; i < 2 * spaces; i++) {
                sb.append(" ");
            }
            return sb.toString();
        }
        int i = 0;
        int to = spaces / 2;

        for (; i < to; i++) {
            sb.append(" ");
        }

        to += spaces / 2;
        char ch = ' ';
        if (node.left != null) {
            ch = '_';
        }
        for (; i < to; i++) {
            sb.append(ch);
        }

        String value = Integer.toString(node.val);
        sb.append(value);

        to += spaces / 2;
        ch = ' ';
        if (node.right != null) {
            ch = '_';
        }
        for (i += value.length(); i < to; i++) {
            sb.append(ch);
        }
        to += spaces / 2;
        for (; i < to; i++) {
            sb.append(' ');
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        int n = 30;
        TreeNode[] nodes = new TreeNode[n];
        for (int i = 0; i < n; i++) {
            nodes[i] = new TreeNode(i + 1);
        }

        for (int i = 0; i < n; i++) {
            int l = 2 * i + 1;
            int r = 2 * i + 2;
            if (l < n) {
                nodes[i].left = nodes[l];
            }

            if (r < n) {
                nodes[i].right = nodes[r];
            }
        }
        TreeNode root = nodes[0];
        printTree(root);
    }
}