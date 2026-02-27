class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        
        int windowsum=0;// this keep add the window of zize minutes not 0 but 1(grumpy)
        // 0 is added in the zerosum
        int zerosum=0;// this adds the value when grumpy is 0
        int maxwindowsum=0;// it keeps track of the maxwindow each time
        int n=customers.length;

        for(int i=0;i<n;i++){ // it iterates through the entire length of customers
           // grumpy is 0 then add it to the zerosum as it mention the whole day
            if(grumpy[i]==0) zerosum+=customers[i];
   // add the value until the i is less than minutes and add those window only for 
   //grumpy is 1 because 0 is added in zerosum so make it a 0.
            if(i<minutes) windowsum+=(grumpy[i]==1 ? customers[i]:0);
   // if it exeeds first add the nextelement only grumpy is 1 else simply make it 0
   // then substract the first element from the start only if it is i-minutes(3-3)==1
   // else make it 0 and move to the nxt element 
            else{ windowsum+=(grumpy[i]==1 ?customers[i] :0);
                  windowsum-=(grumpy[i-minutes]==1?customers[i-minutes]:0);
            }
            // each and everytime check the maxwindowsum and update it 
            maxwindowsum=Math.max(maxwindowsum,windowsum);
        }
        return zerosum+maxwindowsum; 
        // finally add the zerosum(1+1+1+7)10 (1,0,1)1+0+5 -> 10 + 6=16
    }
}