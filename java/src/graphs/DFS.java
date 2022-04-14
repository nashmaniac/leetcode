package graphs;

import java.util.Stack;

public class DFS {
    public void visitNode(Graph g, int i, boolean[] visited) {
        Stack<Integer> queue = new Stack<>();
        queue.add(i);

        while(!queue.isEmpty()) {
            int k = queue.pop();
            visited[k] = true;
            System.out.println(k);
            for(int v: g.adjacencyList.get(k)) {
                if(!visited[v]) {
                    queue.push(v);
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
        int n = 10;
        int[][] edges = new int[][] {
            {1, 5},
            {1, 2},
            {2, 3},
            {3, 4}, 
            {3, 9},
            {6, 7},
        };

        Graph g = new Graph(n, false);
        g.generateGraph(edges);
        // g.printGraph();

        DFS b = new DFS();
        b.traverseGraph(g);
    }
}
