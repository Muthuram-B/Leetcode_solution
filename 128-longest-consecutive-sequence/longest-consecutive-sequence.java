class Solution {
    public int longestConsecutive(int[] nums) {
        /* uses the hashmap for a o(n) 

the idea is initially making everything in a array to false 
then do iterating over a element and find its nextnum and prevnum 
do iterating and make it true and note the longestseq
make a currentseq to compare next element and compare with the longestseq
finally return the maximum longestseq obtained
*/

   Map<Integer,Boolean> map=new HashMap<>();
   for(int num:nums) map.put(num,Boolean.FALSE);

   int longestseq=0;

  for(int num:nums){
    int currentseq=1;

    int nextnum=num+1;
    while(map.containsKey(nextnum) && map.get(nextnum)==false){
        currentseq++;
        map.put(nextnum,Boolean.TRUE);

        nextnum++; // increase the nextnum and find if it is present 
    }
    //similarly in reverse direction to check the prevnum
    int prevnum=num-1;
    while(map.containsKey(prevnum) && map.get(prevnum)==false){
        currentseq++;
        map.put(prevnum,Boolean.TRUE);

        prevnum--;
    }
    longestseq=Math.max(longestseq,currentseq);
  }   
  return longestseq;
}
}