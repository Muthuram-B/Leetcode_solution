class Solution {
    public double findMaxAverage(int[] nums, int k) {
        
        int sum=0;
        for(int i=0;i<k;i++){
            sum+=nums[i]; // it adds upto k value to find the sum of initial values
            

        }
        int maxsum=sum;  // we keep maxsum as sum and do the window operations
        int s=0; int e=k;
         while(e<nums.length){
            sum-=nums[s];// remove the prev element and add the end element
            s++;

            sum+=nums[e];
            e++;

            maxsum=Math.max(maxsum,sum); // each and every time check the maxsum and sum 
            // and update the value
         }

         return (double)maxsum/k; // as the maxsum which gives the maximum avg
        



        }
    }
