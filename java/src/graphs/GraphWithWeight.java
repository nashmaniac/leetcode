package graphs;

import java.util.ArrayList;
import java.util.List;

public class GraphWithWeight {
    public int numVertices;
    public List<List<Edge>> adjacencyList;

    public GraphWithWeight(int numVertices) {
        this.numVertices = numVertices;
        this.adjacencyList = new ArrayList<>();

        for(int i=0;i<this.numVertices;i++) {
            this.adjacencyList.add(new ArrayList<>());
        }
    }

    public void addEdge(int s, int d, int w) {
        this.adjacencyList.get(s).add(new Edge(d, w));
    }

}
