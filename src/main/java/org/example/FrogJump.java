package org.example;

public class FrogJump {

    public static void main(String[] args) {
        int [] stones = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,
                21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,
                42,43,44,45,46,47,48,49,50,51,52,53,54,55,56,57,58,59,60,61,62,63};
        System.out.println(canCross(stones));
    }
    public static boolean canCross(int[] stones) {
        if (stones[1] != 1)
            return false;
        if (stones[1] == 1 && stones.length == 2)
            return true;
        return canJumpToLastStone(stones, 1, 1);
    }

    public static boolean canJumpToLastStone(int[] stones, int index, int lastJump) {
        System.out.println("Index : " + index);
        System.out.println("lastJump : " + lastJump);
        boolean flag1 = false;
        boolean flag2 = false;
        boolean flag3 = false;
        if (index >= stones.length || index < 0)
            return false;
        if (index == stones[stones.length-1])
            return true;
        if (stones[index]+lastJump-1 == stones[stones.length-1])
            return true;
        if (stones[index]+lastJump == stones[stones.length-1])
            return true;
        if (stones[index]+lastJump+1 == stones[stones.length-1])
            return true;
        if (stoneExists(stones, stones[index]+lastJump-1, index) != -1){
            flag1= canJumpToLastStone(stones, stoneExists(stones, stones[index]+lastJump-1, index), lastJump-1);
        }
        if (flag1)
            return true;
        if (stoneExists(stones, stones[index]+lastJump, index) != -1){
            flag2= canJumpToLastStone(stones, stoneExists(stones, stones[index]+lastJump, index), lastJump);
        }
        if (flag2)
            return true;
        if (stoneExists(stones, stones[index]+lastJump+1, index) != -1) {
            flag3 = canJumpToLastStone(stones, stoneExists(stones, stones[index]+lastJump+1, index), lastJump+1);
        }

        return flag3;
    }

    public static int stoneExists(int[] stones, int key, int startIndex) {
        if(stones[startIndex] == key)
            return -1;
        System.out.println("finding island : " + key);
        for (int i = startIndex+1; i < stones.length; i++)
            if (stones[i] == key)
                return i;
        return -1;
    }
}