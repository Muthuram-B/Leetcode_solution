class Solution {
    public int singleNumber(int[] nums) {
    //     int count;
    //     for(int i=0;i<nums.length;i++){
    //          count=0;
    //         for(int j=0;j<nums.length;j++){
    //             if(nums[i]==nums[j]){
    //                 count++;
    //             }
    //         }
        
    //     if(count==1) return nums[i];
    //     }
    
    // return 0;
    // }

    int result=0;
    for(int num:nums)  result^=num;

    return result;
    }
}