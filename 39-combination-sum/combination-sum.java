class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // to retur the answer
        List<List<Integer>> result=new ArrayList<>();
        //to sort the list because if we sort it 1,2,5,9  if tar =5 means then we can skip the 
        // value after 5
        Arrays.sort(candidates);
        // we use backtrack mechanism here
        backtrack(candidates,target,0,new ArrayList<>(),result);

    return result;  // c-cand t- target  s -starting point, curr-List for answer,res=final ans

    }
    private void backtrack(int[] c,int t,int s,List<Integer> curr,List<List<Integer>> result){
       if(t==0){
        result.add(new ArrayList<>(curr));
        return;
       }
       if(t<0) return;

        for(int i=s;i<c.length;i++){

            // if(i>s && c[i]==c[i-1]) continue;
            // if(c[i]>t) break; // if value is greate skip
        
        curr.add(c[i]);//add it to the curr list
        backtrack(c,t-c[i],i,curr,result);
        /* so here the t-c[i] reduce the iteration of all possibl sum for eg 7-2 =5  after 5-2 =3 after 3-2=1  then if(2>1) so remove 2 and loop ends and i++ then 3>3 false after add 3 and then 3-3=0 .
         if it is 0 then we find the combination of the value which give the sum of the target . Note here i is given not i+1 because we can also use the same value again*/
        curr.remove(curr.size()-1); // it remove element that is not make answer from last
    }
}}

/*candidates = [2,3,6,7]
target = 7
Recursive Steps (Clean Walkthrough)
Step 1: Start
curr = [], target = 7

Loop over candidates starting at index 0

Step 2: Pick 2
curr = [2], target = 5

Recurse again

Step 2a: Pick 2 again
curr = [2,2], target = 3

Recurse again

Step 2a(i): Pick 2 again
curr = [2,2,2], target = 1

2 > target → stop

Backtrack → remove last 2

Step 2a(ii): Pick 3
curr = [2,2,3], target = 0

🎉 Found solution → save [2,2,3]

Backtrack → remove 3

Step 2a(iii): Pick 6 or 7
Both > target (3) → stop

Backtrack to [2,2]

Step 2b: Pick 3
curr = [2,3], target = 2

Recurse again

Step 2b(i): Pick 2
curr = [2,3,2], target = 0

🎉 Found solution → save [2,3,2]

But since we always move forward in sorted order, this is essentially the same as [2,2,3].

Backtrack → remove 2

Step 2b(ii): Pick 3, 6, 7
All > target (2) → stop

Backtrack to [2]

Step 2c: Pick 6
curr = [2,6], target = -1

Invalid → stop

Step 2d: Pick 7
curr = [2,7], target = -2

Invalid → stop

Backtrack to []

Step 3: Pick 3
curr = [3], target = 4

Recurse again

Step 3a: Pick 3 again
curr = [3,3], target = 1

Next candidates > target → stop

Step 3b: Pick 6 or 7
Both > target (4) → stop

Backtrack to []

Step 4: Pick 6
curr = [6], target = 1

Next candidates > target → stop

Backtrack to []

Step 5: Pick 7
curr = [7], target = 0

🎉 Found solution → save [7]

Backtrack to []

Final Result
Code
[[2,2,3], [7]]
Clean Mental Model
Think of recursion as:

Choose a number

Subtract from target

If target == 0 → save combination

If target < 0 → stop

Backtrack (remove last number)

Try next candidate
*/
