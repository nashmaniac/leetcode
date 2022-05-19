package graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;

public class KosarajuAlgorithm {

    class NodeInfo {
        public int index;
        public int startTime;
        public int endTime;

        public NodeInfo(int i, int t) {
            this.index = i;
            this.startTime = t;
            this.endTime = -1;
        }
    }

    int startTime = 0;

    public void visitNode(Graph g, int index, boolean[] visited, NodeInfo[] result) {
        if (visited[index]) {
            return;
        }

        Stack<Integer> stack = new Stack<>();
        result[index] = new NodeInfo(index, ++startTime);
        stack.push(index);
        while (!stack.isEmpty()) {
            int i = stack.pop();
            visited[i] = true;
            for (int b : g.adjacencyList.get(i)) {
                visitNode(g, b, visited, result);
            }
        }
        result[index].endTime = ++startTime;

    }

    public void visitReverseNode(Graph g, int index, boolean[] visited, List<Integer> temp) {
        if (visited[index]) {
            return;
        }

        Stack<Integer> stack = new Stack<>();
        stack.push(index);
        temp.add(index);
        while (!stack.isEmpty()) {
            int i = stack.pop();
            visited[i] = true;
            for (int b : g.adjacencyList.get(i)) {
                visitReverseNode(g, b, visited, temp);
            }
        }
    }

    public void findFinishingTime(Graph g, boolean[] visited, NodeInfo[] nodeInfos) {
        startTime = 0;
        for (int i = 0; i < g.numVertices; i++) {
            visitNode(g, i, visited, nodeInfos);
        }
    }

    public void runKosaraju(Graph g) {
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[g.numVertices];
        NodeInfo[] nodeInfos = new NodeInfo[g.numVertices];
        findFinishingTime(g, visited, nodeInfos);

        Arrays.sort(nodeInfos, new Comparator<NodeInfo>() {
            @Override
            public int compare(NodeInfo o1, NodeInfo o2) {
                return o1.endTime <= o2.endTime ? -1 : 1;
            }
        });
        for (NodeInfo n : nodeInfos) {
            stack.push(n.index);
            System.out.printf("%d %d %d\n", n.index, n.startTime, n.endTime);
        }

        Graph gt = g.transposeGraph();
        gt.printGraph();
        Arrays.fill(visited, false);

        List<List<Integer>> result = new ArrayList<>();

        while (!stack.isEmpty()) {
            int index = stack.pop();
            if (!visited[index]) {
                List<Integer> temp = new ArrayList<>();
                visitReverseNode(gt, index, visited, temp);
                result.add(temp);
            }
        }

        for (List<Integer> a : result) {
            System.out.println(a.toString());
        }

    }

    public static void main(String[] args) {
        int n = 7;
        int[][] edges = new int[][] {
                { 0, 1 },
                { 1, 2 },
                { 2, 0 },
                { 1, 3 },

                // { 1, 2 },
                // { 2, 3 },
                // { 3, 1 },
                // { 2, 4 },
                // { 4, 5 },
                // { 5, 6 },
                // { 6, 4 },
        };

        Graph g = new Graph(n, true);
        g.generateGraph(edges);
        // g.printGraph();

        KosarajuAlgorithm b = new KosarajuAlgorithm();
        b.runKosaraju(g);
    }
}
