class Solution {
    public int[] runningSum(int[] nums) {
        //int[] prefixsum=new int[nums.length+1];
        // no need of zero idx so we start from 1
        for(int i=1;i<nums.length;i++){
           nums[i]+=nums[i-1];
        }
        return nums;
    }
}