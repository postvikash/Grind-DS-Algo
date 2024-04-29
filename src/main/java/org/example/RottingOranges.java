package org.example;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class RottingOranges {

    public static void main(String[] args) {
        int[][] grid = {{2,1,1},{1,1,0},{0,1,1}};
        System.out.println(orangesRotting(grid));
/*        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        queue.add(2);
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.size());*/
    }

    public static int orangesRotting(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        Queue<Coordinates> queue = new LinkedList<>();
        int freshOrangeCount = 0;
        for(int i = 0; i < rows; i++)
            for(int j = 0; j < cols; j++)
                if (grid[i][j] == 2)
                    queue.add(new Coordinates(i,j));
                else if(grid[i][j] == 1)
                    freshOrangeCount++;
        int totalMinsLapsed = 0;
        while(!queue.isEmpty()) {
            totalMinsLapsed++;
            int currentQSize = queue.size();
            for(int k = 1; k <= currentQSize; k++) {
                Coordinates temp = queue.poll();
                freshOrangeCount = freshOrangeCount - rotAdjacentOranges(temp.getX(), temp.getY(), rows, cols, grid, queue);
            }
            if(freshOrangeCount == 0)
                return totalMinsLapsed;
        }
        return -1;
    }

    public static int rotAdjacentOranges(int i, int j, int rows, int cols,
                                          int[][] grid, Queue<Coordinates> queue) {
        int orangesRotted = 0;
        if (isValid(i-1, j, rows, cols) && grid[i-1][j] == 1) {
            queue.add(new Coordinates(i-1,j));
            grid[i-1][j] = 2;
            orangesRotted++;
        }

        if (isValid(i+1, j, rows, cols) && grid[i+1][j] == 1) {
            queue.add(new Coordinates(i+1,j));
            grid[i+1][j] = 2;
            orangesRotted++;
        }
        if (isValid(i, j-1, rows, cols) && grid[i][j-1] == 1) {
            queue.add(new Coordinates(i,j-1));
            grid[i][j-1] = 2;
            orangesRotted++;
        }

        if (isValid(i, j+1, rows, cols) && grid[i][j+1] == 1) {
            queue.add(new Coordinates(i,j+1));
            grid[i][j+1] = 2;
            orangesRotted++;
        }
        return orangesRotted;
    }

    public static boolean isValid(int i, int j, int rows, int cols) {
        if (i >=0 && i < rows && j >=0 && j < cols)
            return true;
        return false;
    }
}

