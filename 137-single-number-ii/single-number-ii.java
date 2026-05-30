class Solution {
    public int singleNumber(int[] nums) {
        // int res=0;
        // for(int i=0;i<nums.length;i++){
        //     int count=0;
        //     for(int j=0;j<nums.length;j++){
        //         if(nums[i]==nums[j]) count++;
        //     }
        //     if(count==3) continue;
        //     else  res=nums[i];
        // }
        // return res;


        // a simple bitwise modification to make it  a order of n
        /* simple rules   num  and (~num)= 0
                        num xor num = 0
                        num xor 0 = num

        there will be two part  ones bucket and twos bucket 
        the ones buket holds the ele count 1 and if it reaches two then it goes to 
        twos bucket .
        And once the ele count reaches 3 then it is out from twos bucket and 
        finally you can return the ones bucket 
        [2,2,3,2]
        0^2 & ~0 = 2       0^2 & ~2=0(2 moved to ones)
        2^2 & ~0 = 0(removed 2)   0^2 & 0=2
        0^3 & ~2 =3(~2=-3 so 3 and -3 are same as per commutative)   2^3 &~3 = 2
        3^2 & ~2= 3      2^2 and ~3 =0

        return ones(3)
 
        */
           int ones=0;
           int twos=0;
        for(int num:nums){
            ones =(ones ^ num) & ~twos;
            twos =(twos ^ num) & ~ones;
        }
        return ones;
    }
}