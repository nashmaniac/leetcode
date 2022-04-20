package graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

class DirectedGraph {
    public int numVertices;
    public List<List<Edge>> edges;

    public DirectedGraph(int n) {
        this.numVertices = n;
        this.edges = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            this.edges.add(i, new ArrayList<>());
        }
    }

    public void addEdge(int index, int dest, int weight) {
        this.edges.get(index).add(new Edge(dest, weight));
    }

}

public class DjikstraAlgorithm {

    class DjikstraResult {
        int[] dist;
        int[] prev;
        public DjikstraResult(int[] d, int[] prev) {
            this.dist = d;
            this.prev = prev;
        }
    }

    public DjikstraResult runDjikstra(DirectedGraph g, int source, int dest) {
        int[] dist = new int[g.numVertices];
        int[] prev = new int[g.numVertices];
        boolean[] visited = new boolean[g.numVertices];

        Arrays.fill(dist, Integer.MAX_VALUE);
        Arrays.fill(prev, -1);
        dist[source] = 0;

        PriorityQueue<Edge> queue = new PriorityQueue<>(new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                if(o1.weight <= o2.weight) return -1;
                return 1;
            }
        });
        queue.offer(new Edge(source, 0));

        while(!queue.isEmpty()) {
            Edge node = queue.poll();
            if(visited[node.index]) continue;

            if(node.index == dest) {
                break;
            }

            for(Edge e: g.edges.get(node.index)) {
                if(dist[node.index] + e.weight < dist[e.index]) {
                    dist[e.index] = dist[node.index] + e.weight;
                    prev[e.index] = node.index;
                    queue.offer(new Edge(e.index, dist[e.index]));
                }
            }
        }
        return new DjikstraResult(dist, prev);
    }


    public void findMinimumPath(DirectedGraph g, int source, int dest) {
        DjikstraResult r = this.runDjikstra(g, source, dest);

        System.out.printf("The cost is %d\n", r.dist[dest]);

        List<Integer> path = new ArrayList<>();
        for(int i=dest; i!=-1; i=r.prev[i]) {
            path.add(i);
        }
        Collections.reverse(path);
        System.out.printf("The path is %s\n", path.toString());
    }

    public static void main(String[] args) {
        int n = 5;
        DjikstraAlgorithm d = new DjikstraAlgorithm();
        DirectedGraph g = new DirectedGraph(n);

        int[][] graph = new int[][] {
            {0, 2, 1},
            {0, 1, 4},
            {2, 1, 2},
            {1, 3, 9}, 
            {2, 3, 5},
            {3, 4, 3},
        };

        for(int[] a: graph) {
            g.addEdge(a[0], a[1], a[2]);
        }

        d.findMinimumPath(g, 0, 4);
    }
}
