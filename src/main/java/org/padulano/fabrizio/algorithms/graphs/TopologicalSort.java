package org.padulano.fabrizio.algorithms.graphs;

import java.util.*;

/**
 * https://leetcode.com/problems/course-schedule-ii
 */
public class TopologicalSort {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        for(int i = 0; i < numCourses; i++) {
            adj.put(i, new ArrayList<Integer>());
        }

        for(int[] courses : prerequisites) {
            int crs = courses[0];
            int pre = courses[1];
            adj.get(crs).add(pre);
        }

        Queue<Integer> order = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        Set<Integer> complted = new HashSet<>();

        for(int i = 0; i < numCourses; i++) {
            if(!dfs(adj, i, order, visited, complted)) return new int[] {};
        }

        int[] orderArray = new int[numCourses];
        for(int i = 0; i < numCourses; i++) {
            orderArray[i] = order.remove();
        }

        return orderArray;
    }

    private boolean dfs(
            Map<Integer, List<Integer>> adj,
            int course,
            Queue<Integer> order,
            Set<Integer> visited,
            Set<Integer> completed
    ) {
        if(visited.contains(course)) return false;
        if(completed.contains(course)) return true;

        visited.add(course);

        for(int req : adj.get(course)) {
            if(!dfs(adj, req, order, visited, completed)) return false;
        }

        visited.remove(course);
        completed.add(course);
        order.add(course);

        return true;
    }
}
