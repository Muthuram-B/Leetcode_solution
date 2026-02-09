class Solution {
    public int longestOnes(int[] nums, int k) {
        int zerocount=0;
        int maxone=0;  int s=0;

        for(int e=0;e<nums.length;e++){
            if(nums[e]==0) zerocount++;

            while(zerocount>k) { //if it reach then remove ele from front and check if it is 
            //zero or not
                if(nums[s]==0) zerocount--;
             // 0 then dec zerocount
                s++;
                // else simply s++
            }
            maxone=Math.max(maxone,e-s+1);
            // each and every time chenk the one
        }
        return maxone;
    }
}