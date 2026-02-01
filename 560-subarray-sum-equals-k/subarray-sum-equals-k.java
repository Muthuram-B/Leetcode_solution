class Solution {
    public int subarraySum(int[] nums, int k) {
     Map<Integer,Integer> sumcountmap=new HashMap<>();

     sumcountmap.put(0,1);

     int res=0;
     int prefixsum=0;
     for(int num:nums){
        prefixsum+=num;
        if(sumcountmap.containsKey(prefixsum-k)){
            res+=sumcountmap.get(prefixsum-k);
        }
        sumcountmap.put(prefixsum,
        sumcountmap.getOrDefault(prefixsum,0)+1);
     }   
     return res;
    }
}