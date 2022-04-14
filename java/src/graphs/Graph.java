package graphs;

import java.util.ArrayList;
import java.util.List;

public class Graph {
    public int numVertices;
    public List<List<Integer>> adjacencyList;
    public boolean isDirected;

    public Graph(int n, boolean isDirected) {
        this.numVertices = n;
        this.isDirected = isDirected;
        this.adjacencyList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            this.adjacencyList.add(new ArrayList<>());
        }
    }

    public void addEdge(int source, int destination) {
        this.adjacencyList.get(source).add(destination);
        if (!this.isDirected) {
            this.adjacencyList.get(destination).add(source);
        }
    }

    public void generateGraph(int[][] g) {
        for(int[] i: g) {
            this.addEdge(i[0], i[1]);
        }
    }

    public void printGraph() {
        int count = 0;
        for(List<Integer> points: this.adjacencyList) {
            System.out.printf("%d %s\n", count, points.toString());
            count++;
        }
    }
}
