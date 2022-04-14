package graphs;

import java.util.LinkedList;
import java.util.Queue;

public class CycleDetectionBFS {
    class Pair {
        int value;
        int parent;

        Pair(int v, int p) {
            this.value = v;
            this.parent = p;
        }
    }

    public boolean visitNode(Graph g, int i, boolean[] visited) {
        if (g.isDirected) {
            Queue<Integer> queue = new LinkedList<>();
            queue.add(i);

            while (!queue.isEmpty()) {
                int k = queue.poll();
                if(visited[k]) return true;
                visited[k] = true;
                // System.out.println(k);
                for (int v : g.adjacencyList.get(k)) {
                    if (!visited[v]) {
                        queue.offer(v);
                    } else {
                        return true;
                    }
                }
            }
            return false;
        } else {
            Queue<Pair> queue = new LinkedList<>();
            queue.add(new Pair(i, -1));

            while (!queue.isEmpty()) {
                Pair k = queue.poll();
                visited[k.value] = true;
                for (int v : g.adjacencyList.get(k.value)) {
                    if(k.parent != v && visited[v]) {
                        return true;
                    }
                    if (!visited[v]) {
                        queue.offer(new Pair(v, k.value));
                    } 
                }
            }
            return false;
        }

    }

    public void detectCycle(Graph g) {
        boolean cycleFound = false;
        boolean[] visited = new boolean[g.numVertices];
        for (int i = 0; i < g.numVertices; i++) {
            if (!visited[i]) {
                cycleFound = visitNode(g, i, visited);
                if (cycleFound) {
                    break;
                }
            }
        }
        if (cycleFound) {
            System.out.println("cycle found");
        } else {
            System.out.println("cycle not found");
        }
    }

    public static void main(String[] args) {
        int n = 4;
        int[][] edges = new int[][] {
                { 0, 1 },
                { 1, 2 },
                { 2, 3 },
                { 3, 1 },
        };

        Graph g = new Graph(n, false);
        g.generateGraph(edges);
        g.printGraph();

        CycleDetectionBFS b = new CycleDetectionBFS();
        b.detectCycle(g);
    }
}
