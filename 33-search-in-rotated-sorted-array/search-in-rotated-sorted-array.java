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
/*Recursive search trace for array 4, 5, 6, 7, 0, 1, 2 with target 0
Setup
Array: 
[
4
,
5
,
6
,
7
,
0
,
1
,
2
]

Indices: 
[
0
,
1
,
2
,
3
,
4
,
5
,
6
]

Target: 
0

Initial call: 
modBinarySearch
(
𝑛
𝑢
𝑚
𝑠
,
0
,
  
𝑙
𝑒
𝑓
𝑡
=
0
,
  
𝑟
𝑖
𝑔
ℎ
𝑡
=
6
)

Step-by-step recursion trace
Call 1: left = 0, right = 6
Mid index: 
𝑚
𝑖
𝑑
=
0
+
6
2
=
3

Mid value: 
𝑛
𝑢
𝑚
𝑠
[
3
]
=
7

Check target at mid: 
7
≠
0

Left half sorted?: 
𝑛
𝑢
𝑚
𝑠
[
𝑙
𝑒
𝑓
𝑡
]
=
4
≤
𝑛
𝑢
𝑚
𝑠
[
𝑚
𝑖
𝑑
]
=
7
⇒
 left half 
[
4
,
5
,
6
,
7
]
 is sorted

Is target in left half?: Check 
4
≤
0
<
7
 → false

Decision: Recurse right

Next call: 
modBinarySearch
(
𝑛
𝑢
𝑚
𝑠
,
0
,
  
𝑙
𝑒
𝑓
𝑡
=
4
,
  
𝑟
𝑖
𝑔
ℎ
𝑡
=
6
)

Call 2: left = 4, right = 6
Mid index: 
𝑚
𝑖
𝑑
=
4
+
6
2
=
5

Mid value: 
𝑛
𝑢
𝑚
𝑠
[
5
]
=
1

Check target at mid: 
1
≠
0

Left half sorted?: 
𝑛
𝑢
𝑚
𝑠
[
𝑙
𝑒
𝑓
𝑡
]
=
0
≤
𝑛
𝑢
𝑚
𝑠
[
𝑚
𝑖
𝑑
]
=
1
⇒
 left half 
[
0
,
1
]
 is sorted

Is target in left half?: Check 
0
≤
0
<
1
 → true

Decision: Recurse left

Next call: 
modBinarySearch
(
𝑛
𝑢
𝑚
𝑠
,
0
,
  
𝑙
𝑒
𝑓
𝑡
=
4
,
  
𝑟
𝑖
𝑔
ℎ
𝑡
=
4
)

Call 3: left = 4, right = 4
Mid index: 
𝑚
𝑖
𝑑
=
4
+
4
2
=
4

Mid value: 
𝑛
𝑢
𝑚
𝑠
[
4
]
=
0

Check target at mid: 
0
=
0
 → found

Return: 
4*/