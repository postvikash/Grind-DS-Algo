package org.example;

public class H_Index_Of_Publisher {

    public static void main(String [] args) {
        int [] citations = {0,0,1,1,1,1,2,3,3,};
        int k = hIndex(citations);
        System.out.println("H Index of publisher is : " + k);
    }
    public static int hIndex(int[] citations) {
        int max = citations.length;
        while (max > 0) {
            int count = 0;
            for (int i = 0; i < citations.length; i++)
                if (citations[i] >= max)
                    count++;
            if (count >= max)
                return max;
            max--;
        }
        return 0;
    }
}
