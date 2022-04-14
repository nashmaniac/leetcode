

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LeetcodeProblem207 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjacencyList = new ArrayList<List<Integer>>();
        for(int i=0;i<numCourses;i++) {
            adjacencyList.add(new ArrayList<>());
        }

        int[] incomingEdgeCount = new int[numCourses];
        for(int[] i: prerequisites) {
            adjacencyList.get(i[0]).add(i[1]);
            incomingEdgeCount[i[1]]++;
        }

        Queue<Integer> processedNode = new LinkedList<>();
        List<Integer> nodeList = new ArrayList<>();
        for(int i=0;i<numCourses;i++) {
            if(incomingEdgeCount[i] == 0) {
                processedNode.add(i);
            }
        }

        while(!processedNode.isEmpty()) {
            int n = processedNode.poll();
            nodeList.add(n);
            for(Integer b: adjacencyList.get(n)) {
                incomingEdgeCount[b]--;
                if(incomingEdgeCount[b] == 0) {
                    processedNode.add(b);
                }
            }
        }
        if(nodeList.size() == numCourses) {
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        LeetcodeProblem207 l = new LeetcodeProblem207();
        System.out.println(l.canFinish(2, new int[][]{{1, 0}}));
        System.out.println(l.canFinish(2, new int[][]{{1, 0}, {0, 1}}));
    }
}
