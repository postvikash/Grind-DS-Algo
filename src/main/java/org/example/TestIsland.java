package org.example;

public class TestIsland {
    public static void main(String[] args) {
        char [][] arr = {{'1','1','1'}, {'0','1','0'}, {'1','1','1'} };
        NumOfIsland numOfIsland = new NumOfIsland();
        System.out.println(numOfIsland.numIslands(arr));
    }
}
