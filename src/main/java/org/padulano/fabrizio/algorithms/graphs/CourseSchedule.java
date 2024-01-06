package org.padulano.fabrizio.algorithms.graphs;

import java.util.*;

/**
 * https://leetcode.com/problems/course-schedule/
 * **/
public class CourseSchedule {
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> adj = new HashMap<>();

        for(int i = 0; i < numCourses; i++) {
            adj.put(i, new ArrayList<Integer>());
        }

        for(int i = 0; i < prerequisites.length; i++) {
            int pre = prerequisites[i][0];
            int post = prerequisites[i][1];
            List<Integer> list = adj.get(pre);
            list.add(post);
        }

        Set<Integer> visited = new HashSet<>();
        for(int i = 0; i < numCourses; i++) {
            if(hasCycle(i, adj, visited)) return false;
        }

        return true;
    }

    private static boolean hasCycle(int course,
                             Map<Integer, List<Integer>> adj, Set<Integer> visited) {
        if(visited.contains(course)) return true;
        if(adj.get(course).isEmpty()) return false;
        visited.add(course);

        for(int pre : adj.get(course)) {
            if(hasCycle(pre, adj, visited)) return true;
        }

        visited.remove(course);
        adj.put(course, new ArrayList<Integer>());

        return false;
    }
}
