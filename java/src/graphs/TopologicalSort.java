package graphs;

import java.util.LinkedList;
import java.util.Queue;

public class TopologicalSort {

    public void sort(Graph g) {

        int[] result = new int[g.numVertices];
        int startIndex = 0;

        int[] incomingEdgeCount = new int[g.numVertices];
        for (int i = 0; i < g.numVertices; i++) {
            for (int a : g.adjacencyList.get(i)) {
                incomingEdgeCount[a]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < g.numVertices; i++) {
            if (incomingEdgeCount[i] == 0) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            int k = queue.poll();
            result[startIndex++] = k;
            for (int i : g.adjacencyList.get(k)) {
                incomingEdgeCount[i]--;
                if (incomingEdgeCount[i] == 0) {
                    queue.offer(i);
                }
            }
        }

        for(int i: result) {
            System.out.printf("%d ", i);
        }
        System.out.println();

    }

    public static void main(String[] args) {
        int n = 8;
        int[][] edges = new int[][] {
                { 0, 1 },
                { 0, 2 },
                { 0, 3 },
                { 1, 5 },
                { 3, 5 },
                { 5, 6 },
                { 4, 7 },
        };

        Graph g = new Graph(n, true);
        g.generateGraph(edges);
        g.printGraph();

        TopologicalSort b = new TopologicalSort();
        b.sort(g);
    }
}
