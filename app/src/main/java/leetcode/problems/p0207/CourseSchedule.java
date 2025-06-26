package leetcode.problems.p0207;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CourseSchedule {

    boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> graph = buildGraph(numCourses, prerequisites);

        Set<Integer> visited = new HashSet<>();
        Set<Integer> recursionStack = new HashSet<>();

        for (int course = 0; course < numCourses; course++) {
            if (!visited.contains(course)) {
                if (hasCycle(course, graph, visited, recursionStack)) {
                    return false;
                }
            }
        }
        return true;
    }

    boolean hasCycle(int node, Map<Integer, List<Integer>> graph, Set<Integer> visited, Set<Integer> path) {
        if (path.contains(node)) {
            return true; // Has a cycle.
        }
        if (visited.contains(node)) {
            return false; // Visited
        }

        visited.add(node);
        path.add(node);

        for (int neighbour : graph.getOrDefault(node, Collections.emptyList())) {
            if (hasCycle(neighbour, graph, visited, path)) {
                return true;
            }
        }

        path.remove(node); // Backtrack
        return false;
    }

    Map<Integer, List<Integer>> buildGraph(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            graph.put(i, new ArrayList<>());
        }
        for (int[] prerequisite : prerequisites) {
            int prerequisiteCourse = prerequisite[1];
            int subsequentCourse = prerequisite[0];
            graph.get(prerequisiteCourse).add(subsequentCourse);
        }
        return graph;
    }
}
