package graphs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class GraphColoring {

    class Pair {
        int value;
        int parent;

        Pair(int v, int p) {
            this.value = v;
            this.parent = p;
        }
    }

    public boolean colorNode(Graph g, int i, int[] color) {
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(i, -1));
        while(!queue.isEmpty()) {
            Pair p = queue.poll();
            if(p.parent == -1) {
                color[p.value] = 0;
            } else {
                if(color[p.parent] == 0) {
                    color[p.value] = 1;
                } else {
                    color[p.value] = 0;
                }
            }

            for(int k: g.adjacencyList.get(p.value)) {
                if(color[k] != -1 && color[p.value] == color[k]) {
                    return false;
                }
                if(color[k] == -1) {
                    queue.offer(new Pair(k, p.value));
                }
                
            }
            
        }
        return true;
    }

    public void colorGraph(Graph g) {
        int[] color = new int[g.numVertices];
        for (int i = 0; i < g.numVertices; i++) {
            color[i] = -1;
        }

        boolean coloringPossible = true;
        for (int i = 0; i < g.numVertices; i++) {
            if(color[i] == -1) {
                coloringPossible = colorNode(g, i, color);
                if(!coloringPossible) {
                    break;
                }
            }
        }

        if(!coloringPossible) {
            System.out.println("coloring not possible");
        } else {
            System.out.println("coloring possible");
        }
        System.out.println(Arrays.toString(color));

    }

    public static void main(String[] args) {
        int n = 9;
        int[][] edges = new int[][] {
                { 0, 1 },
                { 1, 2 },
                { 2, 3 },
                { 1, 7 },
                { 3, 4 },
                { 4, 8 },
                {7, 8},
                { 4, 5 },
                { 5, 6 },
        };

        Graph g = new Graph(n, false);
        g.generateGraph(edges);
        g.printGraph();

        GraphColoring gp = new GraphColoring();
        gp.colorGraph(g);
    }
}
