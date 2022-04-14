import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeetcodeProblem133 {
    class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    public Node cloneGraph(Node node, Map<Node, Node> hashMap) {
        // first create a node
        if (node == null) {
            return null;
        }

        Node newNode = new Node(node.val);
        hashMap.put(node, newNode);

        for (Node n : node.neighbors) {
            Node p = hashMap.get(n);
            if (p == null) {
                newNode.neighbors.add(cloneGraph(n, hashMap));
            } else {
                newNode.neighbors.add(p);
            }
        }
        return newNode;
    }

    public Node cloneGraph(Node node) {
        Map<Node, Node> hashMap = new HashMap<>();
        return cloneGraph(node, hashMap);
    }
}
