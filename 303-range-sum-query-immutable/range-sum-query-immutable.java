class NumArray {
private int[] prefix;
    public NumArray(int[] nums) {
        prefix=new int[nums.length+1]; // it takes a new matrix
     for (int i=0;i<nums.length;i++){
         prefix[i+1]=nums[i]+prefix[i];// it sums the previous ele and the curr element to hold
         // the prefixsum of each element 
     }
    }
    
    public int sumRange(int left, int right) {
        return  prefix[right+1]-prefix[left];// this just helps to get the sum of respective 
        // range which is given
    } 
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */