class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        
         int n=nums.length;
        int[] res=new int[n];

        int l=0;int r=n-1;
        int leftres=0; int rightres=n-1;
        while(l<n){
            if(nums[l]<pivot) res[leftres++]=nums[l];
            if(nums[r]>pivot) res[rightres--]=nums[r];
            l++;
            r--;
        }
        while(leftres<=rightres) res[leftres++]=pivot;

        return res;

    }
}