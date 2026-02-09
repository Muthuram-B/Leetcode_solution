class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int minLenWindow=Integer.MAX_VALUE;
        int currentSum=0;

        int low =0;
        int high=0;
        while(high<nums.length){
            currentSum+=nums[high];
            high++;
            while(currentSum>=target){
                int currentWindowSize=high-low;
                minLenWindow=Math.min(minLenWindow,currentWindowSize);

                currentSum-=nums[low];
                low++;
            }
            
        }
        return minLenWindow == Integer.MAX_VALUE ?0:minLenWindow;
    }
}
/* in this the approach is sliding window with two pointer variable which is efficient for the minimum length of the subarray that gives the sum == target .First the minLen is updated to the infinity to reatain the edge case and the sum is 0 .Initially the two pointer are initalized then the loop itearates and add the values upcoming to form the possible minimum subarray then if the sum is > target then the inner loop makes the currentwindow size and it makes the low pointer moves forward to get the possible min subarray for minimmal solution
Example: target = 7, nums = [2,3,1,2,4,3]

Let’s trace:

minLenWindow = INF

currentSum = 0

low = 0, high = 0

Step 1: high = 0

Add nums[0] = 2 → currentSum = 2

high = 1

currentSum (2) < 7 → inner while doesn’t run

Step 2: high = 1

Add nums[1] = 3 → currentSum = 5

high = 2

currentSum (5) < 7 → nothing

Step 3: high = 2

Add nums[2] = 1 → currentSum = 6

high = 3

currentSum (6) < 7 → nothing

Step 4: high = 3

Add nums[3] = 2 → currentSum = 8

high = 4

Now currentSum >= target (8 ≥ 7) → enter inner while:

Inner while:

currentWindowSize = high - low = 4 - 0 = 4

minLenWindow = min(INF, 4) = 4

Shrink:

currentSum -= nums[low] = 8 - 2 = 6

low = 1

Now currentSum = 6 < 7 → exit inner while

Step 5: high = 4

Add nums[4] = 4 → currentSum = 6 + 4 = 10

high = 5

currentSum (10) >= 7 → enter inner while:

Inner while:

currentWindowSize = 5 - 1 = 4

minLenWindow = min(4, 4) = 4

Shrink:

currentSum = 10 - nums[1] = 10 - 3 = 7

low = 2

Still currentSum (7) >= 7, loop again:

currentWindowSize = 5 - 2 = 3

minLenWindow = min(4, 3) = 3

Shrink:

currentSum = 7 - nums[2] = 7 - 1 = 6

low = 3

Now currentSum = 6 < 7 → exit inner while

Step 6: high = 5

Add nums[5] = 3 → currentSum = 6 + 3 = 9

high = 6

currentSum >= 7 → inner while:

Inner while:

currentWindowSize = 6 - 3 = 3

minLenWindow = min(3, 3) = 3

Shrink:

currentSum = 9 - nums[3] = 9 - 2 = 7

low = 4

Still currentSum >= 7:

currentWindowSize = 6 - 4 = 2

minLenWindow = min(3, 2) = 2 ✅

Shrink:

currentSum = 7 - nums[4] = 7 - 4 = 3

low = 5

Now currentSum = 3 < 7, exit.

high eventually reaches nums.length, outer while ends.

Final:

minLenWindow = 2
return 2;


Which is correct, because the smallest subarray is [4,3].*/