class Solution {
    public int threeSumClosest(int[] nums, int target) {

        Arrays.sort(nums);
        int closestSum=nums[0]+nums[1]+nums[2];
        for(int i=0;i<nums.length-2;i++){
            int left=i+1;
            int right=nums.length-1;

            while(left<right){
                int sum=nums[i]+nums[left]+nums[right];

                if(Math.abs(target-sum)<Math.abs(target-closestSum)){
                    closestSum=sum;

                }else if(sum<target){left++ ;}
                else if(sum>target){right-- ;}
                else{
                    return sum;
                }

            }
        }
        return closestSum;
        
    }
}
/*nums = [-1, 2, 1, -4], target = 1

🔹 Step 1: Sort the array
java
Arrays.sort(nums);
Sorted nums = [-4, -1, 1, 2]

🔹 Step 2: Initialize closestSum
java
int closestSum = nums[0] + nums[1] + nums[2];
First three elements: -4 + (-1) + 1 = -4

So, closestSum = -4

🔹 Step 3: Outer loop (iterate i from 0 to nums.length - 3)
We’ll try each number as the first element of the triplet.

Iteration 1: i = 0 (nums[i] = -4)
left = 1, right = 3

While loop runs while left < right.

Step A:

sum = -4 + (-1) + 2 = -3

Compare with target:

|1 - (-3)| = 4

|1 - (-4)| = 5

Since 4 < 5 → update closestSum = -3

sum < target → move left++ → left = 2

Step B:

sum = -4 + 1 + 2 = -1

Compare:

|1 - (-1)| = 2

|1 - (-3)| = 4

Since 2 < 4 → update closestSum = -1

sum < target → move left++ → left = 3

Now left == right, exit loop.

Iteration 2: i = 1 (nums[i] = -1)
left = 2, right = 3

Step A:

sum = -1 + 1 + 2 = 2

Compare:

|1 - 2| = 1

|1 - (-1)| = 2

Since 1 < 2 → update closestSum = 2

sum > target → move right-- → right = 2

Now left == right, exit loop.

Iteration 3: i = 2 (nums[i] = 1)
left = 3, right = 3

Condition left < right fails immediately → no loop.

🔹 Step 4: End of loop
Return closestSum.

Final result:

java
return closestSum; // 2
✅ Answer: The code returns 2, which is the sum closest to target = 1.
*/