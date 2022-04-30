import java.util.Comparator;
import java.util.PriorityQueue;

public class LeetcodeProblem1584 {
    class Edge {
        public int source;
        public int dest;
        public int weight;

        public Edge(int s, int d, int w) {
            this.source = s;
            this.dest = d;
            this.weight = w;
        }
    }

    class UnionFind {
        int numVertices;
        int[] id;
        int[] size;
        int numComponents;

        public UnionFind(int n) {
            this.numComponents = this.numVertices = n;
            this.id = new int[n];
            this.size = new int[n];
            for (int i = 0; i < n; i++) {
                id[i] = i;
                size[i] = 1;
            }
        }

        public int find(int p) {
            int root = p;
            while (root != id[root]) {
                root = id[root];
            }

            while (p != root) {
                int next = id[p];
                id[p] = root;
                p = next;
            }
            return root;
        }

        public void union(int i, int j) {
            int root1 = find(i);
            int root2 = find(j);

            if (this.size[root1] <= this.size[root2]) {
                this.size[root2] += this.size[root1];
                this.id[root1] = root2;
            } else {
                this.size[root1] += this.size[root2];
                this.id[root2] = root1;
            }
            this.numComponents--;
        }

        public boolean isConnected(int i, int j) {
            return find(i) == find(j);
        }
    }

    public int minCostConnectPoints(int[][] points) {
        // find the edges
        int n = points.length;
        PriorityQueue<Edge> pq = new PriorityQueue<>(new Comparator<Edge>() {
            @Override
            public int compare(LeetcodeProblem1584.Edge o1, LeetcodeProblem1584.Edge o2) {
                if (o1.weight <= o2.weight)
                    return -1;
                return 1;
            }
        });
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                int x1 = points[i][0];
                int y1 = points[i][1];

                int x2 = points[j][0];
                int y2 = points[j][1];

                int d = Math.abs(x1 - x2) + Math.abs(y1 - y2);
                pq.offer(new Edge(i, j, d));
                pq.offer(new Edge(j, i, d));
            }
        }

        int cost = 0;
        UnionFind u = new UnionFind(n);

        while (!pq.isEmpty()) {
            Edge e = pq.poll();
            if (!u.isConnected(e.source, e.dest)) {
                u.union(e.source, e.dest);
                System.out.printf("Node %d with node %d weight %d\n", e.source, e.dest, e.weight);
                cost += e.weight;
            }
        }

        if (u.numComponents > 1) {
            return 0;
        }

        return cost;
    }

    public static void main(String[] args) {
        LeetcodeProblem1584 l = new LeetcodeProblem1584();

        int[][] points = new int[][] { { 0, 0 }, { 2, 2 }, { 3, 10 }, { 5, 2 }, { 7, 0 } };
        System.out.println(l.minCostConnectPoints(points));
    }

}
