class Solution {
    public int maxAbsoluteSum(int[] nums) {

         int maxsum=0; int currmax=0; int minsum=0; int currmin=0;     
  
        for(int num:nums){

            currmax=Math.max(num,num+currmax);
            maxsum=Math.max(currmax,maxsum);

            currmin=Math.min(num,num+currmin);
            minsum=Math.min(currmin,minsum);

        }
        return Math.max(Math.abs(maxsum),Math.abs(minsum));
    }
}