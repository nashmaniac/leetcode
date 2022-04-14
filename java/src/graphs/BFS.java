package graphs;

import java.util.LinkedList;
import java.util.Queue;

public class BFS {
    public void visitNode(Graph g, int i, boolean[] visited) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(i);

        while(!queue.isEmpty()) {
            int k = queue.poll();
            visited[k] = true;
            System.out.println(k);
            for(int v: g.adjacencyList.get(k)) {
                if(!visited[v]) {
                    queue.offer(v);
                }
            }
        }

    }
    public void traverseGraph(Graph g) {
        boolean[] visited = new boolean[g.numVertices];
        for(int i=0;i<g.numVertices;i++) {
            if(!visited[i]) {
                visitNode(g, i, visited);
            }
            
        }
    }

    public static void main(String[] args) {
        int n = 9;
        int[][] edges = new int[][] {
            {1, 5},
            {1, 2},
            {2, 3},
            {3, 4}, 
            {6, 7},
        };

        Graph g = new Graph(n, false);
        g.generateGraph(edges);
        // g.printGraph();

        BFS b = new BFS();
        b.traverseGraph(g);
    }
}
