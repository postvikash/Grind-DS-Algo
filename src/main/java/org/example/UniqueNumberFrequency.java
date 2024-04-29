package org.example;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class UniqueNumberFrequency {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> numAndFrequency = new HashMap<>();
        for(int x : arr) {
            if(numAndFrequency.get(x) != null)
                numAndFrequency.put(x, numAndFrequency.get(x)+1);
            else
                numAndFrequency.put(x, 1);
        }
        Set<Integer> integerSet = new HashSet<>();
        for(Map.Entry<Integer, Integer> entry : numAndFrequency.entrySet()) {
            if(!integerSet.add(entry.getValue()))
                return false;
        }
        return true;
    }
}
