class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
       /* Map<Integer,Integer> map=new HashMap<>();
        int count=0; int sum=0;
        for(int num:nums){
            sum+=num;
            if(sum==goal) count++;

            if(map.containsKey(sum-goal)){
                count+=map.get(sum-goal);
            }
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return count;*/
    return helper(nums,goal)-helper(nums,goal-1);

    }
        public int helper(int[] nums,int goal){
            if(goal<0) return 0;
       int l=0; int res=0; int cursum=0;
       for(int r=0;r<nums.length;r++){
        cursum+=nums[r];
         while(l<nums.length && cursum>goal){
            cursum-=nums[l];
            l++;
         }
         res+=(r-l+1);
       }
       return res;
        }
    
}