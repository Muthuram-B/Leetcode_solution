class Solution {
    public int maxTurbulenceSize(int[] arr) {
        int maxlen=1; int currlen=1;
         
         int lastdirection=0;
        for(int i=1;i<arr.length;i++){

            int currentdirection=Integer.compare(arr[i],arr[i-1]);
           if(currentdirection==0) currlen=1;

           else if(currentdirection == -lastdirection) currlen++;

             else currlen=2;

             maxlen=Math.max(maxlen,currlen);
             lastdirection=currentdirection;

        }
        return maxlen;
    }
}
/*
The Ultimate Test Road: arr = [3, 7, 2, 2, 10, 20]
Let’s trace this array step-by-step to see how every single condition in the code gets activated.🎒 
Initial SetupmaxLen = 1, currentLen = 1, lastDirection = 0

Step 1: Moving from 3 to 7 (i = 1)Integer.compare(7, 3) → 1 (UP)
What happens: This is our first move. The code falls into the else block (Rule 2 because it's the start).
Scores: currentLen = 2. maxLen becomes 2.
Save: lastDirection = 1

Step 2: Moving from 7 to 2 (i = 2) ➡️ Triggers Condition 1: Perfect Zigzag ✨Integer.compare(2, 7) → -1 (DOWN)
What happens: The last move was UP (1). The new move is DOWN (-1). They alternate perfectly! The else if (currentDirection == -lastDirection) condition triggers.
Scores: currentLen increases to 3. maxLen becomes 3.
Save: lastDirection = -1

Step 3: Moving from 2 to 2 (i = 3) ➡️ 
Triggers Condition 2: Rule 1 (Flat Road) 🛑Integer.compare(2, 2) → 0 (FLAT)
What happens: The road goes completely flat. The if (currentDirection == 0) condition triggers. Your bike stops.
Scores: currentLen completely resets to 1. maxLen stays 3.
Save: lastDirection = 0

Step 4: Moving from 2 to 10 (i = 4)Integer.compare(10, 2) → 1 (UP)
What happens: We start moving up from a flat stop. The code falls into the else block (Rule 2) to start a fresh hill.
Scores: currentLen = 2. maxLen stays 3.
Save: lastDirection = 1


Step 5: Moving from 10 to 20 (i = 5) ➡️ Triggers Condition 3: Rule 2 (Two Hills) 🛑Integer.compare(20, 10) → 1 (UP)
What happens: We went UP from 2 to 10, and now we go UP again from 10 to 20! The zigzag breaks. The else block (Rule 2) triggers because the trend repeated.
Scores: The old streak dies, but we keep the current hill between 10 and 20, so currentLen resets to 2. maxLen stays 
3.Save: lastDirection = 1

Final ResultThe loop finishes, and the code returns maxLen, which is 3 (from the perfect [3, 7, 2] zigzag segment). */