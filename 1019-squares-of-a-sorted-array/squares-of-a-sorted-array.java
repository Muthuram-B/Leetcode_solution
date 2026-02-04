class Solution {
    public int[] sortedSquares(int[] nums) {
       // Arrays.sort(nums);
        // for(int i=0;i<nums.length;i++){
        //     nums[i]= nums[i]*nums[i];
        // }
        // Arrays.sort(nums);
        // return nums;


        int[] res=new int[nums.length];
        for(int i=0;i<nums.length;i++){
            nums[i]=nums[i]*nums[i];
        }
        int s=0 ; int e=nums.length-1;
        for(int j=nums.length-1;j>=0;j--){
            if(nums[s]>nums[e]){ // elements greater will be placed at the end one by one 
                res[j]=nums[s];
                s++;
            }else{
                res[j]=nums[e];
                e--;
            }
        }
        return res;
    }
}