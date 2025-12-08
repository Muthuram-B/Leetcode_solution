class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        boolean oneExist = false;

        // Step 1: Check if 1 exists in the array
        /*Array: [3, 4, -1, 1]

n: 4

Step 1: Check if 1 exists
Loop i=0: nums[0] = 3 → not 1 → continue

Loop i=1: nums[1] = 4 → not 1 → continue

Loop i=2: nums[2] = -1 → not 1 → continue

Loop i=3: nums[3] = 1 → equals 1 → set oneExist = true and break

Result: 1 exists, so we don’t return yet.*/
        for (int i = 0; i < n; i++) {
            if (nums[i] == 1) {
                oneExist = true;
                break;
            }
        }

        // If 1 is missing, it's the smallest missing positive
        if (!oneExist) return 1;

        // Step 2: Replace invalid numbers (≤0 or >n) with 1 that is every negative or larger 
        // than the size are set to 1
        /*Replace invalid numbers with 1 (values ≤ 0 or > n)
Loop i=0: nums[0] = 3 → valid (1..4) → keep

Loop i=1: nums[1] = 4 → valid → keep

Loop i=2: nums[2] = -1 → invalid → set to 1

Loop i=3: nums[3] = 1 → valid → keep

Array after normalization: [3, 4, 1, 1]*/
        for (int i = 0; i < n; i++) {
            if (nums[i] <= 0 || nums[i] > n) {
                nums[i] = 1;
            }
        }

        // Step 3: Use index as a hash key and mark presence
        /*Mark presence using indices
Rule:

If val == n, mark nums[0] negative (tracks presence of n).

Else mark nums[val] negative (tracks presence of val in 1..n-1).

Use absolute values since entries may be negative after marking.

Loop i=0:

val = |nums[0]| = |3| = 3

val != n (3 != 4)

Mark nums[3] = -|nums[3]| = -|1| = -1

Array: [3, 4, 1, -1]

Loop i=1:

val = |nums[1]| = |4| = 4

val == n (4 == 4)

Mark nums[0] = -|nums[0]| = -|3| = -3

Array: [-3, 4, 1, -1]

Loop i=2:

val = |nums[2]| = |1| = 1

val != n

Mark nums[1] = -|nums[1]| = -|4| = -4

Array: [-3, -4, 1, -1]

Loop i=3:

val = |nums[3]| = |-1| = 1

val != n

Mark nums[1] = -|nums[1]| = -|-4| = -4 (already negative, stays -4)

Array: [-3, -4, 1, -1]

Interpretation of marks:

nums[0] negative: number 4 exists

nums[1] negative: number 1 exists

nums[3] negative: number 3 exists

nums[2] positive: candidate missing at index 2 → number 2*/
        for (int i = 0; i < n; i++) {
            int val = Math.abs(nums[i]);
            if (val == n) {
                // Special case: use index 0 to mark presence of n
                nums[0] = -Math.abs(nums[0]);
            } else {
                nums[val] = -Math.abs(nums[val]);
            }
        }

        // Step 4: Find the first index with a positive value
        /*Scan for the first positive index
We scan from index 1 to n-1 for the first positive.

i=1: nums[1] = -4 → negative → 1 exists

i=2: nums[2] = 1 → positive → missing number is i = 2

Return:

Answer: 2

If no positive found between 1..n-1, we would check:

nums[0] > 0 → means n is missing, return n

Else return n + 1 But here we already found the missing number at index 2.

Final result
First missing positive for [3, 4, -1, 1]: 2*/
        for (int i = 1; i < n; i++) {
            if (nums[i] > 0) {
                return i; // i is missing
            }
        }

        // Step 5: Check if n is missing
        if (nums[0] > 0) return n;

        // If all numbers 1..n are present, return n+1
        return n + 1;
    }
    }
