package org.example;

import java.util.LinkedList;

public class KthLargestElement {
    public static int findKthLargest(int[] nums, int k) {
        int[] heapSimulator = new int[k];
        for (int i = 0; i < nums.length; i++) {
            if (i < k)
                heapSimulator[i] = nums[i];
            else {
                insertIntoHeap(heapSimulator, nums[i]);
            }
        }
        return getMinimum(heapSimulator);
    }

    public static void insertIntoHeap(int[] heapSimulator, int key) {
        int indexOfMin = 0;
        for (int i = 1; i < heapSimulator.length; i++) {
            if (heapSimulator[i] < heapSimulator[indexOfMin])
                indexOfMin = i;
        }
        if (heapSimulator[indexOfMin] < key) {
            heapSimulator[indexOfMin] = key;
        }
    }

    public static int getMinimum(int[] heapSimulator) {
        int indexOfMin = 0;
        for (int i = 1; i < heapSimulator.length; i++) {
            if (heapSimulator[i] < heapSimulator[indexOfMin])
                indexOfMin = i;
        }
        return heapSimulator[indexOfMin];
    }
}
