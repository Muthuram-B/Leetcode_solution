class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        
        int maxsum=Integer.MIN_VALUE; int currmax=0;
        int minsum=Integer.MAX_VALUE; int currmin=0;
        int total=0;

        for(int i=0;i<nums.length;i++){

            total+=nums[i];
            currmax=Math.max(nums[i],nums[i]+currmax);
            maxsum=Math.max(maxsum,currmax);
            /* eg 5,-3,5 the masum=7 after every iteration since it is circular
            we use the logic minsum(it keep track of min ele possible)
            minsum=-3  and if we do total =7 and total-minsum (7-(-3)=10) */

            currmin=Math.min(nums[i],nums[i]+currmin);
            minsum=Math.min(minsum,currmin);
        }
        if(maxsum<0) return maxsum; // edge case for all negative integers

        /*eg = -5,-3,-5   the maxsum = -3
          total = -13 and minsum=-13  total-minsum=0 to handle that we just
          return the maxsum it holds the least negative integer*/

        return Math.max(maxsum,total-minsum);
    }
}
