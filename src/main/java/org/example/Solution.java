package org.example;

class CustomHeap {
    int capacity;
    int size;
    int[] minHeap;
    CustomHeap() {
        minHeap = new int[10];
        capacity = 10;
        size = 0;
    }
    CustomHeap(int capacity) {
        minHeap = new int[capacity];
        this.capacity = capacity;
        size = 0;
    }
    public void insertIntoHeap(int key) {
        if(size < capacity) {
            minHeap[size] = key;
            size++;
            heapifyUp(minHeap, size-1);
        } else if ( key > minHeap[0]) {
            minHeap[0] = key;
            heapifyDown(minHeap, 0);

        }
    }

    public void printHeap() {
        for (int i = 0; i < size; i++) {
            System.out.println(minHeap[i]);
        }
    }

    public void heapifyUp(int[] minHeap, int indexOfLastElement) {
        if (indexOfLastElement <= 0)
            return;
        //size - 1 refers to last element in the heap
        int parentIndex = (indexOfLastElement - 1)/2;
        if(minHeap[parentIndex] > minHeap[indexOfLastElement]) {
            int temp = minHeap[parentIndex];
            minHeap[parentIndex] = minHeap[indexOfLastElement];
            minHeap[indexOfLastElement] = temp;
        }
        heapifyUp(minHeap, parentIndex);
    }

    public void heapifyDown(int[] minHeap, int startIndex) {
        int leftIndex = 2*startIndex+1;
        int rightIndex = 2*startIndex+2;
        int smallerIndex = leftIndex;
        if (leftIndex >= size)
            return;
        if (rightIndex >= size) {
            rightIndex = -1;
            smallerIndex = leftIndex;
        }
        else if (minHeap[rightIndex] < minHeap[leftIndex])
            smallerIndex = rightIndex;
        if(minHeap[startIndex] > minHeap[smallerIndex]) {
            int temp = minHeap[startIndex];
            minHeap[startIndex] = minHeap[smallerIndex];
            minHeap[smallerIndex] = temp;
        }
        heapifyDown(minHeap, smallerIndex);

    }

    public static void main(String[] args) {
        CustomHeap customHeap = new CustomHeap(5);
        customHeap.insertIntoHeap(7);
        customHeap.printHeap();
        System.out.println("********");
        customHeap.insertIntoHeap(6);
        customHeap.printHeap();
        System.out.println("********");
        customHeap.insertIntoHeap(5);
        customHeap.printHeap();
        System.out.println("********");
        customHeap.insertIntoHeap(4);
        customHeap.printHeap();
        System.out.println("********");
        customHeap.insertIntoHeap(3);
        customHeap.printHeap();
        System.out.println("********");
        customHeap.insertIntoHeap(2);
        customHeap.printHeap();
        System.out.println("********");
        customHeap.insertIntoHeap(1);
        customHeap.printHeap();

    }

}

class Solution {
    public int findKthLargest(int[] nums, int k) {
        CustomHeap customHeap = new CustomHeap(k);
        for (int i = 0; i < nums.length; i++) {
            customHeap.insertIntoHeap(nums[i]);
        }
        return customHeap.minHeap[0];

    }

    public void insertIntoHeap(int[] heapSimulator, int key) {
        int indexOfMin = 0;
        for (int i = 1; i < heapSimulator.length; i++) {
            if (heapSimulator[i] < heapSimulator[indexOfMin])
                indexOfMin = i;
        }
        if (heapSimulator[indexOfMin] < key) {
            heapSimulator[indexOfMin] = key;
        }
    }

    public int getMinimum(int[] heapSimulator) {
        int indexOfMin = 0;
        for (int i = 1; i < heapSimulator.length; i++) {
            if (heapSimulator[i] < heapSimulator[indexOfMin])
                indexOfMin = i;
        }
        return heapSimulator[indexOfMin];
    }
}