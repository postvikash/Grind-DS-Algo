package org.example;

public class SearchSorted2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if(target >= matrix[i][j] && target <= matrix[i][cols-1])
                    return binarySearch(matrix[i], target, 0, cols);
                else
                    break;
            }
        }
        return false;
    }

    public int findPivotIndex(int[] array) {
        int start = 0;
        int end = array.length-1;
        while(start <= end) {
            int mid = (start+end)/2;
            if(mid+1 <= end && array[mid] > array[mid+1])
                return mid;
            else if(array[mid] < array[end])
                end = mid-1;
            else
                start = mid+1;
        }
        return 0;
    }

    public boolean binarySearch(int[] array, int key, int start, int end) {
        while(start <= end) {
            int mid = (start+end)/2;
            if (array[mid] == key)
                return true;
            if (key < array[mid])
                end = mid-1;
            else
                start = mid+1;
        }
        return false;
    }
}
