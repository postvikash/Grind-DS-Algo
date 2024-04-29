package org.example;
import java.util.Stack;

public class NumOfIsland {
    public static int numIslands(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int numOfIslands = 0;
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if(grid[i][j] == '1') {
                    numOfIslands++;
                    dfs(i, j, grid, rows, cols);
                }
            }
        }
        return numOfIslands;
    }

    public static void dfs(int i, int j, char[][] grid, int rows, int cols) {
        if ( i < rows && i >= 0 && j < cols && j >= 0 && grid[i][j] == 1) {
            grid[i][j] = '-';
            dfs(i-1, j, grid, rows, cols);
            dfs(i, j-1, grid, rows, cols);
            dfs(i+1, j, grid, rows, cols);
            dfs(i, j+1, grid, rows, cols);
        }
    }
}

