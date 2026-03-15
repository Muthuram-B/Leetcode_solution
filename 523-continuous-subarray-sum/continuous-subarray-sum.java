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
/*If two prefix sums have the same remainder when divided by k, the difference between them is divisible by k.
Example:

prefixsum[j] % k = prefixsum[i] % k

Then (prefixsum[j] - prefixsum[i]) % k = 0 → subarray sum divisible by k.

The condition i - map.get(remainder) > 1 ensures the subarray length is at least 2.

map.put(0,-1) handles the case where the subarray starts at index 0.

📊 Example
Let’s test with nums = [23,2,4,6,7], k = 6.

Start: map = {0:-1}, sum=0

i=0 → sum=23 → remainder=5 → map={0:-1,5:0}

i=1 → sum=25 → remainder=1 → map={0:-1,5:0,1:1}

i=2 → sum=29 → remainder=5 → already in map at index 0 → i-map.get(5)=2-0=2 > 1 → return true

So the subarray [2,4] has sum=6, divisible by k.*/