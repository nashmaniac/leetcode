package graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class TarjanAlgorithmSCC {

    int id = 0;
    int sccCount = 0;
    int[] ids, lows;
    boolean[] inStack;
    Stack<Integer> stack;
    List<List<Integer>> graph;
    int UNVISITED = -1;

    public List<List<Integer>> buildGraph(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] i : edges) {
            int s = i[0];
            int d = i[1];
            graph.get(s).add(d);
        }

        return graph;
    }

    public void dfs(int at) {
        stack.push(at);
        inStack[at] = true;
        ids[at] = lows[at] = id++;

        for (int to : graph.get(at)) {
            if (ids[to] == UNVISITED) {
                dfs(to);
            }
            if (inStack[to]) {
                lows[at] = Math.min(lows[to], lows[at]);
            }
        }
 
        if (lows[at] == ids[at]) {
            for (int node = stack.pop();; node = stack.pop()) {
                inStack[node] = false;
                lows[node] = ids[at];
                if (node == at) {
                    break;
                }
            }
        }

    }

    public List<List<Integer>> runTarjanAlgorithm(int n, int[][] edges) {
        List<List<Integer>> result = new ArrayList<>();
        graph = buildGraph(n, edges);
        ids = new int[n];
        lows = new int[n];
        inStack = new boolean[n];
        stack = new Stack<Integer>();

        for (int i = 0; i < n; i++) {
            ids[i] = UNVISITED;
        }
        for (int i = 0; i < n; i++) {
            if (ids[i] == UNVISITED) {
                dfs(i);
            }
        }
        System.out.println(Arrays.toString(lows));
        return result;
    }

    public static void main(String[] args) {
        int n = 4;
        int[][] edges = new int[][] {
                { 0, 1 },
                { 1, 2 },
                { 2, 0 },
                { 1, 3 },
        };

        TarjanAlgorithmSCC t = new TarjanAlgorithmSCC();
        t.runTarjanAlgorithm(n, edges);

    }

}
