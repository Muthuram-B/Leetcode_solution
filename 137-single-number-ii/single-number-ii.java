class Solution {
    public int singleNumber(int[] nums) {
        int res=0;
        for(int i=0;i<nums.length;i++){
            int count=0;
            for(int j=0;j<nums.length;j++){
                if(nums[i]==nums[j]) count++;
            }
            if(count==3) continue;
            else  res=nums[i];
        }
        return res;
    }
}