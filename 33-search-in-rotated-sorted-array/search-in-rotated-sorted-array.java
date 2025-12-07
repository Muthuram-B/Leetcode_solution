class Solution {
    public int search(int[] nums, int target) {
        return modBinarySearch(nums,target,0,nums.length-1);
    }

        private int modBinarySearch(int[] nums,int target, int left,int right){
     // edge case where we dont find any element 
       if(left>right) return -1;
/* we use modified binary search approach to find the element with O(log n)*/
      int mid =  (left+right)/2; //left+ ((right-left)/2);

     if(nums[mid]==target) return mid;
/*Note in rotated sorted array if first elment is larger than the target means all the element remaning in those are larger*/ 
    /* another if which checks if the left array is sorted (if it first value is smaller than the mid then it is sorted else it is not sorted)*/
    if(nums[mid]>=nums[left]){
        //left half is sorted 

        //to check key is in left half
        if(nums[left]<=target && target<=nums[mid])  return modBinarySearch(nums,target,left,mid-1);
        else return modBinarySearch(nums,target,mid+1,right);
    } else{
        // right half is sorted

        //if key is in right half
        if(nums[mid]<=target && target<=nums[right]) return modBinarySearch(nums,target,mid+1,right);
        else return modBinarySearch(nums,target,left,mid-1);

    } 
        }
    
}