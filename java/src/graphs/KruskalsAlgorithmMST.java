package graphs;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

import datastructures.*;
public class KruskalsAlgorithmMST {

    public List<Edge> runAlgo(List<Edge> edges, int n) {
        List<Edge> result = new ArrayList<>();
        Union<Integer>[] nodes = new Union[n];
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
            if(nodes[e.source] == null && nodes[e.index] == null) {
                // create new union
                Union<Integer> u = new Union<>();
                u.addMember(e.source);
                u.addMember(e.index);
                nodes[e.source] = u;
                nodes[e.index] = u;
            } else if(nodes[e.source] != null && nodes[e.index] == null){
                nodes[e.source].addMember(e.index);
                nodes[e.index] = nodes[e.source];
            } else if(nodes[e.source] == null && nodes[e.index] != null) {
                // add node
                nodes[e.index].addMember(e.source);
                nodes[e.source] = nodes[e.index];
            } else {
                // combine nodes
                // find the large one and combine the smaller one. 
                Union<Integer> u1 = nodes[e.source];
                Union<Integer> u2 = nodes[e.index];
                if(u1 == u2) {
                    continue;
                }
                if(u1.size <= u2.size) {
                    u2 = u2.combine(u1);
                    for(Integer member: u1.members) {
                        nodes[member] = u2;
                    }
                } else {
                    u1 = u1.combine(u2);
                    for(Integer member: u2.members) {
                        nodes[member] = u1;
                    }
                }
            }
            result.add(e);
        }

        Union<Integer> uniqueNode = null;
        for(Union<Integer> u: nodes) {
            if(uniqueNode == null) {
                uniqueNode = u;
            } else {
                if(uniqueNode.hashCode() != u.hashCode()) {
                    return null;
                }
            }
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
