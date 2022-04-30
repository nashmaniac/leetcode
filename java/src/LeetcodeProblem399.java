import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class LeetcodeProblem399 {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        HashMap<String, HashMap<String, Double>> graph = buildGraph(equations, values);
        double[] result = new double[queries.size()];
        for (int i = 0; i < result.length; i++) {
            String start = queries.get(i).get(0);
            String end = queries.get(i).get(1);
            result[i] = getPathWeight(start, end, new HashSet<>(), graph);
        }
        return result;
    }

    public double getPathWeight(String start, String end, HashSet<String> visited,
            HashMap<String, HashMap<String, Double>> graph) {

        if (!graph.containsKey(start)) {
            return -1.0;
        }

        if (graph.get(start).containsKey(end)) {
            return graph.get(start).get(end);
        }

        visited.add(start);
        for (Map.Entry<String, Double> neighbor : graph.get(start).entrySet()) {
            if (!visited.contains(neighbor.getKey())) {
                double pathWeight = getPathWeight(neighbor.getKey(), end, visited, graph);
                if (pathWeight != -1.0) {
                    return pathWeight * neighbor.getValue();
                }
            }
        }

        return -1.0;
    }

    public HashMap<String, HashMap<String, Double>> buildGraph(List<List<String>> equations, double[] values) {
        HashMap<String, HashMap<String, Double>> graph = new HashMap<String, HashMap<String, Double>>();

        for (int i = 0; i < equations.size(); i++) {
            String nodeA = equations.get(i).get(0);
            String nodeB = equations.get(i).get(1);
            double dist = values[i];

            graph.putIfAbsent(nodeA, new HashMap<>());
            graph.get(nodeA).put(nodeB, dist);
            graph.putIfAbsent(nodeB, new HashMap<>());
            graph.get(nodeB).put(nodeA, 1.0 / dist);
        }

        return graph;
    }

}
