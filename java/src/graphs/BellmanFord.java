package graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BellmanFord {

    public void runAlgorithm(int[][] edges, int s, int n) {
        int[] dist = new int[n];
        int[] prev = new int[n];
        int MAX_VALUE = 100000000;
        Arrays.fill(dist, MAX_VALUE);
        Arrays.fill(prev, -1);
        dist[s] = 0;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < edges.length; j++) {
                int source = edges[j][0];
                int dest = edges[j][1];
                int weight = edges[j][2];

                if (dist[source] + weight < dist[dest]) {
                    dist[dest] = dist[source] + weight;
                    prev[dest] = source;
                }
            }
        }

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < edges.length; j++) {
                int source = edges[j][0];
                int dest = edges[j][1];
                int weight = edges[j][2];

                if (dist[source] + weight < dist[dest]) {
                    dist[dest] = -MAX_VALUE;
                    prev[dest] = -1;
                }
            }
        }

        System.out.println(Arrays.toString(dist));

        for (int i = 0; i < dist.length; i++) {
            if (dist[i] > -MAX_VALUE) {
                // find the path
                System.out.printf("The cost from %d to %d is %d\n", s, i, dist[i]);

                List<Integer> temp = new ArrayList<>();
                
                for(int e=i;e!=-1;e=prev[e]) {
                    temp.add(e);
                }

                Collections.reverse(temp);

                System.out.printf("The path from %d to %d is %s\n", s, i, temp.toString());

            }
        }

    }

    public static void main(String[] args) {
        int n = 10;
        int s = 0;
        int[][] edges = new int[][] {
                { 0, 1, 5 },
                { 1, 6, 60 },
                { 1, 5, 30 },
                { 1, 2, 20 },
                { 2, 3, 10 },
                { 2, 4, 75 },
                { 3, 2, -15 },
                { 4, 9, 100 },
                { 5, 4, 25 },
                { 5, 6, 5 },
                { 5, 8, 50 },
                { 6, 7, -50 },
                { 7, 8, -10 },
        };

        BellmanFord b = new BellmanFord();
        b.runAlgorithm(edges, s, n);
    }
}
