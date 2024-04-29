package org.example;

import java.util.*;

public class MergeIntervals {

    public static void main(String[] args) {
        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
        int[][] answer = merge(intervals);
    }
    public static int[][] merge(int[][] intervals) {
        if (intervals.length <= 1)
            return intervals;

        // Sort by ascending starting point
        Arrays.sort(intervals, Comparator.comparingInt(i -> i[0]));

        List<int[]> result = new ArrayList<>();

        int[] newInterval = intervals[0];
        result.add(newInterval);

        for (int[] interval : intervals) {
            System.out.println(interval[0]+", "+interval[1]);
            if (interval[0] <= newInterval[1])
                // Overlapping intervals,
                // update the end if needed
                newInterval[1] = Math.max(newInterval[1], interval[1]);
            else {
                // Disjoint intervals,
                // add the new interval to the list
                newInterval = interval;
                result.add(newInterval);
            }
        }

        return result.toArray(new int[result.size()][]);
    }
}
