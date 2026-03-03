class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {


     Map<Integer,Integer> map=new HashMap<>();
     map.put(0,-1);
     int sum=0;
     for(int i=0;i<nums.length;i++){
        sum+=nums[i];
        // k=0 avoids zero divison and sum% k is done inorder to get the sum range
        /*23%6=5
         23+2=25 25%6=1
         25+4=29  29%6=5 repeated 
         if you check the sum of it is equal to k 2+4=6)*/
        int remainder= k==0 ? sum : sum%k;
  
        if(!map.containsKey(remainder)){
            map.put(remainder,i);
        }else if(i-map.get(remainder)>1){
            return true;
        }
     }    
     return false;
    }
}