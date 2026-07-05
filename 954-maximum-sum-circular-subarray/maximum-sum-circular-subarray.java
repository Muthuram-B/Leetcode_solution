class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        
        int maxsum=Integer.MIN_VALUE; int currmax=0;
        int minsum=Integer.MAX_VALUE; int currmin=0;
        int total=0;

        for(int i=0;i<nums.length;i++){

            total+=nums[i];
            currmax=Math.max(nums[i],nums[i]+currmax);
            maxsum=Math.max(maxsum,currmax);

            currmin=Math.min(nums[i],nums[i]+currmin);
            minsum=Math.min(minsum,currmin);
        }
        if(maxsum<0) return maxsum;

        return Math.max(maxsum,total-minsum);
    }
}