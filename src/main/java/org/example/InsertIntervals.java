package org.example;

import java.util.ArrayList;
import java.util.List;

public class InsertIntervals {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> intervalAfterInsert = new ArrayList<>();

        //Iterate over given intervals and insert the new interval
        for(int[] temp: intervals) {
            if(temp[0] >= newInterval[0]) {
                intervalAfterInsert.add(newInterval);
                intervalAfterInsert.add(temp);
            } else {
                intervalAfterInsert.add(temp);
            }
        }
        int[] temp = intervalAfterInsert.get(0);
        List<int[]> result = new ArrayList<>();
        result.add(temp);
        for(int i = 0; i < intervalAfterInsert.size(); i++) {
            if(intervalAfterInsert.get(i)[0] <= temp[1]) {
                temp[1] = Math.max(temp[1], intervalAfterInsert.get(i)[1]);
            } else {
                temp = intervalAfterInsert.get(i);
                result.add(temp);
            }
        }

        return result.toArray(new int[result.size()][]);
    }
}
