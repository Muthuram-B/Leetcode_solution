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

/* eg nums;[1,0,6,-1]  // make 1-fale ; 0-false ; 6-false; -1-false

1 conseq++ then check for nextnum=2  no nextnum

check prevnum =0 found conseq++ (2)  then check nextprevnum =-1 found conseq++(3)

check for -2 not present done with a seq and update longestseq=3

then next ele 0 already true so go to next

then 6 find the nextnum =7 not present find prevnum=5 not present conseq=1

then -1 already true so the longestseq = 3 [-1,0,1] */ 