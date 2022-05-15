import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LeetcodeProblem743 {

    class Edge {
        public int index;
        public int weight;

        public Edge(int i, int w) {
            this.index = i;
            this.weight = w;
        }
    }

    class Node {
        public int nodeIndex;
        public int startTime;

        public Node(int n, int s) {
            this.nodeIndex = n;
            this.startTime = s;
        }
    }

    public int networkDelayTime(int[][] times, int n, int k) {
        // first build the graph
        List<List<Edge>> graph = buildGraph(times, n);
        Stack<Node> stack = new Stack<>();
        int[] cost = new int[n];
        boolean[] visited = new boolean[n];
        for(int i=0;i<n;i++) {
            visited[i] = false;
            cost[i] = Integer.MAX_VALUE;
        }
        stack.push(new Node(k - 1, 0));
        // run dfs from k
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            
            if(node.startTime >= cost[node.nodeIndex]) {
                continue;
            }
            visited[node.nodeIndex] = true;
            cost[node.nodeIndex] = node.startTime;

            for(Edge e: graph.get(node.nodeIndex)) {
                if(node.startTime + e.weight >= cost[e.index]) {
                    // visited before or best value found
                    continue;
                }
                stack.push(new Node(e.index, node.startTime + e.weight));
            }

        }

        int ans = Integer.MIN_VALUE;
        for(int i=0;i<n;i++) {
            ans = Math.max(ans, cost[i]);
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    public List<List<Edge>> buildGraph(int[][] times, int n) {
        List<List<Edge>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < times.length; i++) {
            int s = times[i][0];
            int d = times[i][1];
            int w = times[i][2];

            graph.get(s - 1).add(new Edge(d - 1, w));
        }

        return graph;
    }
}
