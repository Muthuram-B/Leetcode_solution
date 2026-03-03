class Solution {
    public int findMaxLength(int[] nums) {
        // intially makes all 0 to -1

        for(int i=0;i<nums.length;i++){
            if(nums[i]==0) nums[i]=-1;
        }
        // at first 0 is never used so at -1
        Map<Integer,Integer> map=new HashMap<>();
        map.put(0,-1);
        int sum=0;  int maxlen=0;
       for(int i=0;i<nums.length;i++){
          sum+=nums[i];  // sum up each element
       if(map.containsKey(sum)){
        int last=map.get(sum); // if key present then get the value(idx) of it
        // then sub with the current idx to get the maxlen of equal o and 1.
        maxlen=Math.max(maxlen,i-last);
       }else{
          map.put(sum,i);// if not then put the sum with the idx
       }    
      
       }
        return maxlen;
    }
}