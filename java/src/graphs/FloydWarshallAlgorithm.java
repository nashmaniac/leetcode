package graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FloydWarshallAlgorithm {

    class Result {
        int[][] dist;
        int[][] next;

        public Result(int[][] d, int[][] n) {
            this.dist = d;
            this.next = n;
        }
    }

    int MAX_VALUE = 10000000;

    public Result findAllPairShortestPath(int[][] graph, int n) {
        int[][] dist = new int[n][n];
        int[][] next = new int[n][n];
        // set up
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], MAX_VALUE);
            Arrays.fill(next[i], -1);
        }
        
        for (int i = 0; i < n; i++) {
            dist[i][i] = 0;
        }
        for (int i = 0; i < graph.length; i++) {
            dist[graph[i][0]][graph[i][1]] = graph[i][2];
            next[graph[i][0]][graph[i][1]] = graph[i][1];
        }

        // calculate
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                        next[i][j] = k;
                    }
                }
            }
        }

        // negative cycle detection
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = -MAX_VALUE;
                        next[i][j] = -1;
                    }
                }
            }
        }
        return new Result(
                dist, next);
    }

    public void findPath(int i, int j, int[][] dist, int[][] next) {
        System.out.printf("the distance from node %d to node %d is %d\n", i, j, dist[i][j]);

        if (dist[i][j] == -MAX_VALUE) {
            System.out.printf("node %d is unreachable from node %d\n", j, i);
        } else {
            List<Integer> path = new ArrayList<>();
            int at = i;
            while (at != -1) {
                path.add(at);
                if (at == j) {
                    break;
                }
                at = next[at][j];
            }
            if (at != j) {
                System.out.printf("Unreachable to node %d from node %d\n", j, i);
            } else {
                System.out.printf("%s\n", path.toString());
            }
        }

    }

    public static void main(String[] args) {
        int[][] graph = new int[][] {
                { 0, 1, 3 },
                { 1, 0, 8 },
                { 0, 3, 7 },
                { 3, 1, 2 },
                { 2, 3, 1 },
                { 1, 2, 2 },
                { 2, 0, 5 },
        };
        int n = 4;

        FloydWarshallAlgorithm f = new FloydWarshallAlgorithm();
        Result r = f.findAllPairShortestPath(graph, n);
        int source = 0;
        int dest = 2;
        for(int[] i: r.next) {
            System.err.println(Arrays.toString(i));
        }
        f.findPath(source, dest, r.dist, r.next);

    }
}
