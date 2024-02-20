package org.example;

import java.util.ArrayList;
import java.util.List;

class Location {
    int x, y;

    Location(int a, int b) {
        x = a;
        y = b;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public String toString() {
        return x + ", " + y;
    }

    @Override
    public boolean equals(Object obj) {
        Location location = (Location) obj;
        return (location.getX() == this.x && location.getY() == this.y);
    }
    public int searchInsert(int[] nums, int target) {
        return binarySearch(nums, 0, nums.length - 1, target);
    }

    public int binarySearch(int[] nums, int low, int high, int target) {
        if (low > high)
            return -1;
        int mid = (low + high) / 2;
        if (nums[mid] == target)
            return mid;
        if (nums[mid] > target)
            return binarySearch(nums, low, mid - 1, target);
        else
            return binarySearch(nums, mid + 1, high, target);
    }

    public List<String> generatePossibleNextMoves(String currentState) {
        List<String> stringList = new ArrayList<>();
        for (int i = 0; i < currentState.length() - 1; i++) {
            if (currentState.charAt(i) == '+' && currentState.charAt(i + 1) == '+') {
                stringList.add(currentState.substring(0, i) + "--"
                        + currentState.substring(i + 2));
            }
        }
        return stringList;
    }

}
