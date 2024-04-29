package org.example;

import java.util.ArrayList;
import java.util.List;

public class Combinations {
    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> combinations = new ArrayList<>();
        List<Integer> intList = new ArrayList<>(k);
        findCombinations(1, n, k, intList, combinations);
        return combinations;
    }

    public static void findCombinations(int start, int end, int k,
                                        List<Integer> intList, List<List<Integer>> combinations) {
        if (intList.size() == k) {
            combinations.add(new ArrayList<>(intList));
            return;
        }
        for(int i = start; i <= end; i++) {
            intList.add(i);
            findCombinations(i+1, end, k, intList, combinations);
            intList.remove(intList.size()-1);
        }
    }
}
