class Solution {
    public int[] moveZeroes(int[] nums) {
    //     int i=0;
    //     for(int j=0;j<nums.length;j++){
    //         if(nums[j]!=0){
    //             swap(nums,i,j);
    //             i++;
    //         }
    //     }
    // }
    //     public void swap(int[] nums,int i,int j){
    //         int temp=nums[i];
    //         nums[i]=nums[j];
    //         nums[j]=temp;
    //     }
    int j=0;
    for(int i=0;i<nums.length;i++){
        if(nums[i]!=0){
            nums[j++]=nums[i];
        }
    }
    while(j<nums.length)  nums[j++]=0;

 return nums;
    }
}