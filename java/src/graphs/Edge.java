package graphs;

public class Edge {
    public int index;
    public int source;
    public int weight;

    public Edge(int i, int w) {
        this.index = i;
        this.weight = w;
    }

    public Edge(int s, int i, int w) {
        this.index = i;
        this.source = s;
        this.weight = w;
    }
}
