class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        
        if(k<=1) return 0;
        int i=0; int prod=1;  
        int count=0;

        for(int j=0;j<nums.length;j++){
            prod*=nums[j];

            while(prod>=k){
                prod/=nums[i];// if prod > k then we do divisiion
                //eg 10*5*2=100 >k  remove first element 100/10=10(5*2)
                i++;
            }
            count+=(j-i+1);
            
        }
        return count;
    }
}