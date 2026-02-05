class Solution {
    public int numRescueBoats(int[] people, int limit) {

     Arrays.sort(people);
       int boat=0;
     int l=0; int r=people.length-1;
     while(l<=r){

        if(people[l]+people[r]<=limit){
            l++;
        }
    /* 1,2,2,3   here first and second gives 4 but limit 3 so 3 at the end can be put
    in the separate boat and r--
      next 1 + 2=3  so l++  and then r--   1,2 in  a second boat
      then 2 can be put in separte boat and boat count bexomes  3  
      */
        r--;//each and every time it moves after the person is put in it with limit
        boat++;
     }   
     return boat;
    }
}