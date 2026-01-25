class Solution {
    public String minWindow(String s, String t) {
     if(s.length()<t.length()) return "";
     /* it is the base case for the problem*/
     /* it checks the freq count of the words in the list
     t  like A-1 ; B-1; C-1  and update the size*/
     int[] freq=new int[128];
     for(char c:t.toCharArray()){//make each character 
        freq[c]++;
     }   
     int left=0;int right=0;
     int needed=t.length();/*it gives the t string to be completely checked or not*/
     int minstart=0;//initial start
     int minLen=Integer.MAX_VALUE;//sliding window approach

     while(right<s.length()){/*checks from the begining until the end of the s string*/

        char r =s.charAt(right);/*it gets each charcter and then check its freq like freq[A] (1)>0 .. if it is true then need-- to ensure we have obtain the char in the t*/
        if(freq[r]>0){
            needed--;
        }
            freq[r]--;/*removes the freq count of A from 1 to 0..*/
            right++;//move to the next char eg(D)...
        
        while(needed==0){/*if the condition arrived that is the it can be made that it is defined that it reahes the value 0 in the freq list A-0 B-0 C-0*/
            if(right-left<minLen){/*it checks the array size from the initial left to the right it reached eg:ADOBEC 5-0=5 < INFINTY and then update the minLen and also update the minstart=left */

                minLen=right-left;
                minstart=left;// initially 0
            }
            char l=s.charAt(left);/*it checks that another possible string from the upcoming */
            freq[l]++;
            if(freq[l]>0)/*it checks if the value of t is matched A B C ...*/
            needed++;
            left++;
        }
     }
     if(minLen==Integer.MAX_VALUE){
        return "";
     }
     return s.substring(minstart,minstart+minLen);
     /*it checks that all possible values from that minstart reaches 9 and (9+3=12) and it return BANC*/
    }
}

/*
s = "ADOBECODEBANC"

t = "ABC"

We’ll track:

left and right pointers

needed (how many characters from t are still required)

freq[] changes (frequency map of characters)

Current window substring

Decisions made (expand/shrink/update result)

🔎 Initialization
freq after processing t = "ABC" →

Code
freq['A'] = 1
freq['B'] = 1
freq['C'] = 1
needed = 3 (we need 3 characters total).

left = 0, right = 0, minLen = ∞, minstart = 0.

🪟 Step-by-Step Window Movement
Step 1: right = 0 → 'A'
freq['A'] = 1 > 0 → decrement needed = 2.

freq['A']-- → 0.

Window = "A".

Not valid yet (needed != 0).

Step 2: right = 1 → 'D'
freq['D'] = 0 (not in t).

Decrement anyway → freq['D'] = -1.

Window = "AD".

Still needed = 2.

Step 3: right = 2 → 'O'
freq['O'] = 0 → -1.

Window = "ADO".

Still needed = 2.

Step 4: right = 3 → 'B'
freq['B'] = 1 > 0 → decrement needed = 1.

freq['B']-- → 0.

Window = "ADOB".

Still not valid.

Step 5: right = 4 → 'E'
freq['E'] = 0 → -1.

Window = "ADOBE".

Still needed = 1.

Step 6: right = 5 → 'C'
freq['C'] = 1 > 0 → decrement needed = 0.

freq['C']-- → 0.

Window = "ADOBEC".

✅ Now valid (all chars found).

Step 7: Shrink from left while valid
Current window length = 6. Update minLen = 6, minstart = 0.

Try shrinking:

left = 0 → 'A'.

freq['A']++ → 1.

Since freq['A'] > 0, we lost a needed char → needed = 1.

Stop shrinking. Window = "DOBEC".

Step 8–10: Expand right further
right = 6 → 'O' → freq['O'] = -1 → -2.

right = 7 → 'D' → freq['D'] = -1 → -2.

right = 8 → 'E' → freq['E'] = -1 → -2.

Window keeps growing, still needed = 1.

Step 11: right = 9 → 'B'
freq['B'] = 0 → -1.

Window = "DOBECODEB".

Still needed = 1.

Step 12: right = 10 → 'A'
freq['A'] = 1 > 0 → decrement needed = 0.

freq['A']-- → 0.

Window = "DOBECODEBA".

✅ Valid again.

Step 13: Shrink from left
Current window length = 10. Compare with minLen=6 → not smaller.

Shrink:

left = 1 → 'D'. freq['D']++ → -1. Still valid.

left = 2 → 'O'. freq['O']++ → -1. Still valid.

left = 3 → 'B'. freq['B']++ → 0. Still valid.

left = 4 → 'E'. freq['E']++ → -1. Still valid.

left = 5 → 'C'. freq['C']++ → 1. Lost needed char → needed = 1.

Stop shrinking. Window = "ODEBA".

Step 14: right = 11 → 'N'
freq['N'] = 0 → -1.

Window = "ODEBAN".

Still needed = 1.

Step 15: right = 12 → 'C'
freq['C'] = 1 > 0 → decrement needed = 0.

freq['C']-- → 0.

Window = "ODEBANC".

✅ Valid again.

Step 16: Shrink from left
Current window length = 8. Compare with minLen=6 → not smaller.

Shrink:

left = 6 → 'O'. freq['O']++ → 0. Still valid.

left = 7 → 'D'. freq['D']++ → 0. Still valid.

left = 8 → 'E'. freq['E']++ → 0. Still valid.

left = 9 → 'B'. freq['B']++ → 1. Lost needed char → needed = 1.

Stop shrinking. Window = "ANC".

Length = 3. Update minLen = 3, minstart = 9.

🎯 Final Answer
Best window found: "BANC" (from index 9 to 12).

Return "BANC".
*/