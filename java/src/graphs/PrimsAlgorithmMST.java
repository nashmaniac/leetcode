package graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class PrimsAlgorithmMST {

    public List<Edge> runMST(List<List<Edge>> edgeList, int n, int source) {
        List<Edge> edges = new ArrayList<>();
        boolean[] visited = new boolean[n];
        Arrays.fill(visited, false);
        PriorityQueue<Edge> pq = new PriorityQueue<>(new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                if (o1.weight <= o2.weight)
                    return -1;
                return 1;
            }
        });

        // setup the data
        for (Edge e : edgeList.get(source)) {
            pq.offer(e);
        }
        visited[source] = true;

        while (!pq.isEmpty()) {
            Edge e = pq.poll();
            if (!visited[e.index]) {
                visited[e.index] = true;
                edges.add(e);

                for (Edge _e : edgeList.get(e.index)) {
                    if (!visited[_e.index]) {
                        pq.offer(_e);
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                return null;
            }
        }

        return edges;
    }

    public static void main(String[] args) {

        int[][] graph = new int[][] {
                { 0, 4, 2 },
                { 1, 2, 2 },
                { 1, 3, 5 },
                { 1, 6, 3 },
                { 4, 6, 3 },
                { 4, 7, 8 },
                { 5, 6, 7 },
                { 5, 7, 3 },
                { 6, 7, 4 }
        };
        int n = 8;
        List<List<Edge>> edges = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            edges.add(new ArrayList<>());
        }

        for (int[] i : graph) {
            int s = i[0];
            int d = i[1];
            int w = i[2];
            edges.get(s).add(new Edge(s, d, w));
            edges.get(d).add(new Edge(d, s, w));
        }

        PrimsAlgorithmMST prims = new PrimsAlgorithmMST();
        int source = 0;
        List<Edge> result = prims.runMST(edges, n, source);
        int cost = 0;
        for (Edge e : result) {
            cost += e.weight;
            System.out.printf("Source: %d Destination %d Weight %d\n", e.source, e.index, e.weight);
        }
        System.out.printf("Cost is %d\n", cost);

    }
}
