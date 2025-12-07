class Solution {
    public int[] searchRange(int[] nums, int target) {
        int left=findLeftBound(nums,target);
        int right=findRightBound(nums,target);
/*two binary search to avoid the edge cases that is after splitting both the sides have the target element so the 
         first occurence have left value less than it 
         last occurence have right value greater than it
         */
        return new int[]{left,right};
    }
    private int findLeftBound(int[] nums,int target){
        int index=-1,low=0,high=nums.length-1;

        while(low<=high){
            int mid=(low+high)/2;
            if(nums[mid]==target){/*this checks if the mid is same then it mark it as the index and make the search of first index by reducing high = mid-1 and rather is the same*/
                index=mid;
                high=mid-1;
            }else if(nums[mid]<target){
                low =mid+1;
            }else{
                high=mid-1;
            }
            
        }
        return index;
    }
    private int findRightBound(int[] nums,int target){
        int index=-1,low=0,high=nums.length-1;

        while(low<=high){
            int mid=(low+high)/2;
            if(nums[mid]==target){
                index=mid;
                low=mid+1;
            }else if(nums[mid]<target){
                low =mid+1;
            }else{
                high=mid-1;
            }
            
        }
        return index;
}
}
/*Step-by-step example with nums = [5, 7, 7, 8, 8, 10], target = 8
Left bound (findLeftBound)
Initial: low = 0, high = 5, index = -1

Iteration 1:

Mid: 
(
0
+
5
)
/
2
=
2

Value: nums[2] = 7

Action: 7 < 8 ⇒ low = 3

Iteration 2:

Mid: 
(
3
+
5
)
/
2
=
4

Value: nums[4] = 8

Action: found target ⇒ index = 4, move left ⇒ high = 3

Iteration 3:

Mid: 
(
3
+
3
)
/
2
=
3

Value: nums[3] = 8

Action: found target ⇒ index = 3, move left ⇒ high = 2

Stop: low = 3, high = 2 ⇒ loop ends.

Result: left bound = 3

Right bound (findRightBound)
Initial: low = 0, high = 5, index = -1

Iteration 1:

Mid: 
(
0
+
5
)
/
2
=
2

Value: nums[2] = 7

Action: 7 < 8 ⇒ low = 3

Iteration 2:

Mid: 
(
3
+
5
)
/
2
=
4

Value: nums[4] = 8

Action: found target ⇒ index = 4, move right ⇒ low = 5

Iteration 3:

Mid: 
(
5
+
5
)
/
2
=
5

Value: nums[5] = 10

Action: 10 > 8 ⇒ high = 4

Stop: low = 5, high = 4 ⇒ loop ends.

Result: right bound = 4

Final output for this input
Answer: [3, 4]*/