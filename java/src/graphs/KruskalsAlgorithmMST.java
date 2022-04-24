package graphs;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

import datastructures.*;
public class KruskalsAlgorithmMST {

    public List<Edge> runAlgo(List<Edge> edges, int n) {
        List<Edge> result = new ArrayList<>();
        UnionFind u = new UnionFind(n);
        PriorityQueue<Edge> pq = new PriorityQueue<>(new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                if(o1.weight <= o2.weight) return -1;
                return 1;
            }
        });
        for(Edge e: edges) {
            pq.offer(e);
        }

        while(!pq.isEmpty()) {
            Edge e = pq.poll();
            if(!u.isConnected(e.index, e.source)) {
                u.unify(e.index, e.source);
                result.add(e);
            }
        }
        if(u.componentCount() > 1) {
            return null;
        }

        return result;
    }


    public static void main(String[] args) {
        int[][] graph = new int[][] {
                { 0, 1, 4 },
                { 0, 7, 8 },
                { 1, 2, 8 },
                { 1, 7, 11 },
                { 2, 8, 2 },
                { 2, 3, 7 },
                { 2, 5, 4 },
                { 3, 4, 9 },
                { 3, 5, 14 },
                { 4, 5, 10 },
                { 5, 6, 2 },
                { 6, 8, 6 },
                { 6, 7, 1 },
                { 7, 8, 7 },
        };
        int n = 9;
        List<Edge> edgesList = new ArrayList<>();
        for (int i = 0; i < graph.length; i++) {
            int s = graph[i][0];
            int d = graph[i][1];
            int w = graph[i][2];
            edgesList.add(new Edge(s, d, w));
            // edgesList.add(new Edge(d, s, w));
        }

        KruskalsAlgorithmMST k = new KruskalsAlgorithmMST();
        List<Edge> result = k.runAlgo(edgesList, n);
        int cost = 0;
        for (Edge e : result) {
            cost += e.weight;
            System.out.printf("Source: %d Destination %d Weight %d\n", e.source, e.index, e.weight);
        }
        System.out.printf("Cost is %d\n", cost);
    }

}
