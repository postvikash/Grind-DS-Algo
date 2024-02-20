package org.example;
import java.util.Stack;

public class NumOfIsland {
    public int numIslands(char[][] grid) {
        int[][] gridCopy = new int[grid.length][grid[0].length];
        for(int i = 0; i < grid.length; i++)
            for(int j = 0; j < grid[i].length; j++)
                gridCopy[i][j] = (grid[i][j] == '0') ? 0 : 1;
        for(int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++)
                System.out.print(gridCopy[i][j] + " ");
            System.out.print("\n");
        }
        int count = 0;
        Stack<Location> locationStack = new Stack<>();
        int[][] visited = new int[grid.length][grid[0].length];
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[i].length; j++) {
                if (gridCopy[i][j] == 1 && visited[i][j] == 0) {
                    count++;
                    visited[i][j] = count;
                    locationStack.push(new Location(i, j));
                }
                if(!locationStack.empty())
                    bfs(gridCopy, visited, locationStack, count);
            }
        }
        for(int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++)
                System.out.print(visited[i][j] + " ");
            System.out.print("\n");
        }
        return count;
    }

    public void bfs(int[][] gridCopy, int[][] visited, Stack<Location> locationStack, int count) {
        while(!locationStack.empty()) {
            Location coordiates = locationStack.pop();
            int i = coordiates.getX();
            int j = coordiates.getY();
            if (i+1 < gridCopy.length && gridCopy[i+1][j] == 1 && visited[i+1][j] == 0) {
                locationStack.push(new Location(i+1, j));
                visited[i+1][j] = count;
            }
            if (i-1 >= 0 && gridCopy[i-1][j] == 1 && visited[i-1][j] == 0) {
                locationStack.push(new Location(i-1, j));
                visited[i+1][j] = count;
            }
            if (j+1 < gridCopy[0].length && gridCopy[i][j+1] == 1 && visited[i][j+1] == 0) {
                locationStack.push(new Location(i, j+1));
                visited[i][j+1] = count;
            }
            if (j-1 >= 0 && gridCopy[i][j-1] == 1 && visited[i][j-1] == 0) {
                locationStack.push(new Location(i, j-1));
                visited[i][j-1] = count;
            }
        }
    }
}

