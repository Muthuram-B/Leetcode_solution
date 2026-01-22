class Solution {
    public int pivotIndex(int[] nums) {
        
       int rightsum=0;
       for(int num:nums){
        rightsum+=num;
       }
       int leftsum=0;
       for(int i=0;i<nums.length;i++){
         rightsum-=nums[i];
         if(leftsum==rightsum) return i;
         leftsum+=nums[i];
       }
       return -1;
    }
}
/* it initally totals to the rightsum eg: 1+7+3+6+5+6=28
then it removes form the starting element element eg = 28-1=27 and
then it checks 0==27 , its not
again it continues the next element 27-7=20 and 
then it checks 1==20 ,its not and it add to left sum=1+7=8
again it checks   20-3=17 and it 
checks 8==17 ,its not and then it add to left =8+3=11
again it continues 17-6==11 and it checks
11==11 then it return the current index which is 3 here

in this way it takes O{n} and no extra space*/