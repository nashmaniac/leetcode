import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LeetcodeProblem785 {
    class Graph {
        public int numVertices;
        public List<List<Integer>> adjacencyList;

        public Graph(int[][] graph) {
            this.numVertices = graph.length;
            this.adjacencyList = new ArrayList<>();
            for (int i = 0; i < this.numVertices; i++) {
                List<Integer> t = new ArrayList<>();
                for (int j : graph[i]) {
                    t.add(j);
                }
                this.adjacencyList.add(i, t);
            }
        }
    }

    class Node {
        int index;
        int parent;

        public Node(int i, int p) {
            this.index = i;
            this.parent = p;
        }
    }

    public boolean colorGraph(Graph g, int index, int[] color) {
        Node n = new Node(index, -1);
        Queue<Node> queue = new LinkedList<>();
        queue.offer(n);
        while(!queue.isEmpty()) {
            Node p = queue.poll();
            // check if colored already
            if(color[p.index] == -1 || p.parent == -1){
                color[p.index] = 0;
            }

            for(int i: g.adjacencyList.get(p.index)) {
                if(color[i] == -1) {
                    // color and enqueue
                    if(color[p.index] == 0) {
                        color[i] = 1;
                    } else {
                        color[i] = 0;
                    }
                    queue.offer(new Node(i, p.index));
                } else {
                    if(color[i] == color[p.index]) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public boolean isBipartite(int[][] graph) {
        Graph g = new Graph(graph);
        int[] color = new int[g.numVertices];
        Arrays.fill(color, -1);
        for (int i = 0; i < g.numVertices; i++) {
            if(color[i] == -1) {
                boolean isBipartite =colorGraph(g, i, color);
                if(!isBipartite) {
                    return false;
                }
            }
        }
        return true;
    }
}
