class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        //same as 932
        for(int i=0;i<nums.length;i++) 
        nums[i]=nums[i]%2==0?0:1;
         
         return helper(nums,k)-helper(nums,k-1);
    }
    public static int helper(int[] nums,int k){
        int l=0; int cursum=0; int res=0;

        for(int r=0;r<nums.length;r++){
            cursum+=nums[r];

            while(l<nums.length && cursum>k){
                cursum-=nums[l];
                l++;
            }
            res+=(r-l+1);
        }
        return res;
    }
}