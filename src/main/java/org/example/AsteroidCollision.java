package org.example;

import java.util.Stack;

public class AsteroidCollision {

    public static void main(String[] args) {
        int[] nums = {1, -2, -2, -2};
        int[] arr  = asteroidCollision(nums);
        for(int x : arr)
            System.out.println(x);
    }
    public static int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> asteroidState = new Stack<>();
        for(int i = 0; i < asteroids.length; i++) {
            if (asteroidState.empty()) {
                asteroidState.push(asteroids[i]);
                continue;
            }
            int topElement;
            do {
                topElement = asteroidState.peek();
                if ((topElement < 0 && asteroids[i] < 0) ||
                        (topElement > 0 && asteroids[i] > 0)) {
                    asteroidState.push(asteroids[i]);
                    break;
                }
                if (topElement < 0) {
                    asteroidState.push(asteroids[i]);
                    break;
                }
                if (topElement > 0 && Math.abs(topElement) > Math.abs(asteroids[i])) {
                    break;
                }
                if (Math.abs(topElement) == Math.abs(asteroids[i])) {
                    asteroidState.pop();
                    break;
                }
                asteroidState.pop();
            } while(!asteroidState.empty());
            if (asteroidState.empty() && Math.abs(topElement) < Math.abs(asteroids[i]))
                asteroidState.push(asteroids[i]);
        }
        if (asteroidState.empty()) {
            int array[]={};
            return  array;
        }
        int[] answer = new int[asteroidState.size()];
        for(int i = asteroidState.size()-1; i >= 0; i--) {
            answer[i] = asteroidState.pop();
        }
        return answer;
    }
}
