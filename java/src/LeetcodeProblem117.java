import java.util.LinkedList;
import java.util.Queue;

public class LeetcodeProblem117 {
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };

    public Node connect1(Node root) {
        if (root == null) {
            return null;
        }

        Queue<Node> q = new LinkedList<Node>();
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            Node dummy = new Node(-1, null, null, null);
            while (size-- > 0) {
                Node node = q.poll();
                dummy.next = node;
                dummy = dummy.next;
                if(node.left != null) {
                    q.offer(node.left);
                }
                if(node.right != null) {
                    q.offer(node.right);
                }
            }
            dummy.next = null;
        }

        return root;
    }

    public Node connect(Node root) {
        if (root == null) {
            return null;
        }

        Node head = root;
        while (head != null) {
            Node dummy = new Node(0);
            Node temp = dummy;
            while (head != null) {
                if(head.left != null) {
                    temp.next = head.left;
                    temp = temp.next;
                } 
                if(head.right != null) {
                    temp.next = head.right;
                    temp = temp.next;
                } 
                head = head.next;
            }
            head = dummy.next;
        }

        return root;
    }
}
