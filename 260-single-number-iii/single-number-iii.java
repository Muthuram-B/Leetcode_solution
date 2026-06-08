class Solution {
    public int[] singleNumber(int[] nums) {
        // the key idealogy is performing a xor on all the numbers to get uncancel one
         int xored=0;
         for(int num:nums)  xored^=num; // 3 and 5 is uncancel
        // then find the exculsive bit of that numbers
        /* 0 0 1 1 
           0 1 0 1
           0 1 1 0   (xor of 3 and 5) */
        int exclusivebit=0;
        while(true){
            if((xored & 1)==1) break;
            xored=xored>>1;
            exclusivebit++;

        }
        /* 0 1 1 0       0 1 1
        &  0 0 0 1  >>1  0 0 1
           0 0 0 0       0 0 1 ( here it is 2nd position we find rightmost excluxive bit)

           if two numbers are diff then there must be a exclusive bit between them
        */
    //Note : here 3 has bitset 1 at 2nd positon but 5 has bitunset(that is 0) at 2nd

    //so we group the numbers in two bucket like(bitset and bitunset)

    int bitset=0; int bitunset=0;
    for(int num: nums){
        if(((num>>exclusivebit)&1)==1) bitset^=num;
        else bitunset^=num;

}// hew we cancel the ele in both buket and finaaly 3 is left in bitset and 5 in
   //bitunset
    return new int[]{bitset,bitunset};
    }
}