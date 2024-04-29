package org.example;

public class PivotIndexOfSortedRotatedArray {

    public static void main(String[] args) {
        int[] array = {5,1,2,3,4};
        System.out.println(findPivotIndex(array));
    }

    public static int findPivotIndex(int[] array) {
        int start = 0;
        int end = array.length-1;
        System.out.println("start : " + start);
        System.out.println("end : " + end);
        while(start <= end) {
            int mid = (start+end)/2;
            System.out.println("mid : " + mid);
            if(mid+1 <= end && array[mid] > array[mid+1])
                return mid;
            if(mid-1 >= start && array[mid] < array[mid-1])
                return mid;
            else if(array[mid] < array[end]) {
                end = mid - 1;
                System.out.println("start : " + start);
                System.out.println("end : " + end);
            }
            else {
                start = mid + 1;
                System.out.println("start : " + start);
                System.out.println("end : " + end);
            }

        }
        return 0;
    }
}
