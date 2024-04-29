package org.example;

import java.util.LinkedList;
import java.util.Queue;

public class CourseSchedule {
    public static void main(String[] args) {
        int[][] input = {{0,1}, {1,2}};
        System.out.println(canFinish(3, input));
    }

    public static int[] canFinish(int numCourses, int[][] prerequisites) {
        int[][] adj = new int[numCourses][numCourses];
        int[] indegree = new int[numCourses];

        // Create adjacency matrix for the graph
        for(int[] prerequisite :  prerequisites) {
            int i = prerequisite[1];
            int j = prerequisite[0];
            adj[i][j] = 1;
        }
        // Created indegree list
        for(int i = 0; i < numCourses; i++)
            for (int j = 0; j < numCourses; j++)
                indegree[i]+= adj[j][i];
        // Perform BFS to detect cycle in the directed graph
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[numCourses];
        for(int i = 0; i < numCourses; i++)
            if (indegree[i] == 0)
                queue.add(i);
        int count  = 0;
        int[] orderOfCourses = new int[numCourses];
        while(!queue.isEmpty()) {
            int vertex = queue.poll();
            orderOfCourses[count] = vertex;
            count++;
            visited[vertex] = true;
            for(int i = 0; i < numCourses; i++) {
                if(adj[vertex][i] == 1 && visited[i] == false) {
                    indegree[i]--;
                    if(indegree[i] == 0)
                        queue.add(i);
                }
            }
        }
        if (count == numCourses)
            return orderOfCourses;
        return new int[]{};
    }
}
