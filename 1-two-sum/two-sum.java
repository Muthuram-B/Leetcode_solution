class Solution {
    public int[] twoSum(int[] nums, int target) {
//tw0sum
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int comp=target-nums[i];
           if(map.containsKey(comp)){
            return new int[]{map.get(comp),i};
           }
           map.put(nums[i],i);
        }
        return new int[]{};
                
/* the above is O(n)  times that is first it find complement or difference between the 
target from the value , eg  target=9  9-2=7 if we find 7 in hashmap  we can simply return it
index and the current index of the solution. IF not we add the element with its index like
2,0  7,1 .. until the target is found */

                // for(int i=0;i<nums.length;i++){
                //     for(int j=i+1;j<nums.length;j++){
                //         if(nums[i]+nums[j]==target)
                //              return new int[] {i,j};
                //     }
                // }
                // return new int[]{};
    }
}
                
            
        
        
    
