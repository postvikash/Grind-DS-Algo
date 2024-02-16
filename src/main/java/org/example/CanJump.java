package org.example;

class CanJump {
    public static boolean canJump(int[] nums) {
        if (nums[0] == 0 && nums.length == 1)
            return true;
        if (nums[0] == 0)
            return false;
        // find zero and the next postive integer which is greater than
        // distance between its current index and index of the zero under scrutiny
        for(int i = 0; i < nums.length; i++) {
            if (nums[i] == 0 && !checkIfSaviourNumberExistsOnLeft(nums, i))
                return false;
        }
        return true;
    }

    public static boolean checkIfSaviourNumberExistsOnLeft(int[] nums, int pivotIndex) {
        int itr = pivotIndex-1;
        while(itr >= 0) {
            if (nums[itr] > (pivotIndex - itr))
                return true;
            if (nums[itr] == (pivotIndex - itr) && pivotIndex == nums.length-1)
                return true;
            itr--;

        }
        return false;
    }

    public static void main(String [] args) {
        int [] nums = {0,2,3,4,6,8,9};
        System.out.println(canJump(nums));
    }
}
