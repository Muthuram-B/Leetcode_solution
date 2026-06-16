class Solution {
    public int maxProduct(int[] nums) {
        /* the intution is we do leftprod from the left side of the numbers and the rightprod from the n-1 of the elements and find the maxprod from it*/
        int leftprod=1; int rightprod=1;
        int n=nums.length; int ans=nums[0];

        for(int i=0;i<n;i++){

    // in case of 0 in the middle just make it 1 after 0 get multiply with ele

       leftprod=leftprod==0?1:leftprod;
       rightprod=rightprod==0?1:rightprod;

       leftprod*=nums[i];
       rightprod*=nums[n-1-i];

       //compare ans , leftprod ,righprod to find maxprod
       ans=Math.max(ans,Math.max(leftprod,rightprod));

        }
        return ans;
    }
}