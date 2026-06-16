class Solution {
    public int[] productExceptSelf(int[] nums) {
        // the simple intution is that we can make two array leftprod and righprod

        //and once you mul both it gives the correct res
        
        int[] left=new int[nums.length];
        int[] right=new int[nums.length];
/*Eg from left 1-1;  2-1; 3-2;  4-6
    from right 1-24; 2-12; 3-4; 4-1

  multiply both   24;  12;  8;    6;  */   
        left[0]=1;
        for(int i=1;i<nums.length;i++) left[i]=left[i-1]*nums[i-1];

        right[nums.length-1]=1;
        for(int i=nums.length-2;i>-1;i--) right[i]=right[i+1]*nums[i+1];

        int[] res=new int[nums.length];
        for(int i=0;i<nums.length;i++){
            res[i]=left[i]*right[i];
        }

        return res;
}
}