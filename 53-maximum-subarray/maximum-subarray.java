class Solution {
    public int maxSubArray(int[] nums) {
        /*here we uses memoization which is a dynamic programming approach that it stores the value of the previous and use it for the next iteration*/
      //  int max=nums[0];//it gives the maximum value
        //int currMax=nums[0];//it gives the curr max that is upto a certain value

        //for(int i=1;i<nums.length;i++){
            /*let u consider the eq1 where it runs over the loop and initially it checks Math.max(1,1-2(-1))=1  and max=Math.max(1,-2)=1
    i++     then Math.max(-3,-3+1(2))=-2 max=(-2,1)=1
    i++      the currMax=(4,4-2(2))=4 and max=(4,1)=4
    i++       then currMax=(-1,-1+4(3))=3 and max(3,4)=4
    i++   then currMax=(2,2+3(5))=5  and max(5,4)=5
    i++   then currMax=(1,1+5(6))=6 and max(6,5)=6
    i++    then currMax=(-5,-5+6(1))=1  and max(1,6)=6
    i++   then currMax=(4,4+1(5))=5 and max=(5,6)=6  
    so the maximum val of sum of subarray is 6*/
        //     currMax=Math.max(nums[i],nums[i]+currMax);
        //     max=Math.max(currMax,max);
        // }
        // return max;
    

/*here we adds the value in a order and store in curr max and compare the currmax and max and store the max of both and store them and finally use those value with next iteration of element to fing the maximum contigious subarray possible*/


//kadens alogorith
int sum=nums[0];
int maxSum=nums[0];

for(int i=1;i<nums.length;i++){

    if(sum>=0){
        sum+=nums[i];
    }else{
        sum=nums[i];
    }
    if(sum>maxSum) maxSum=sum;
}
    return maxSum;

    }
    }