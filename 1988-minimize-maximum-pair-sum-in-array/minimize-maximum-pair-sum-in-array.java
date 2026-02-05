class Solution {
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int l=0; int r=nums.length-1;
        int maxsum=0;
        while(l<r){
            int pairsum=nums[l]+nums[r];
            maxsum=Math.max(maxsum,pairsum);
            l++;
            r--;
        }
        return maxsum;
    }
}