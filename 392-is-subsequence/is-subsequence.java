class Solution {
    public boolean isSubsequence(String s, String t) {
        int i=0;
        int j=0;
        while(i<s.length() && j<t.length()){
            if(s.charAt(i)==t.charAt(j)){
                i++;
                j++;
            }else{
                j++;

            }

        }
        return (i==s.length());//define i reached end(true)
    }
}
/*logic for the above problem is that it uses the two pointer approach for the effieciency which checks the each and every character of the both the string s and t 
and then iterates the i and j if both have same value
else it iterates the j alone to find the correct match
if it done then true else false
s = "abc", t = "ahbgdc"

i=0 (a), j=0 (a) → match → i=1, j=1

i=1 (b), j=1 (h) → no match → j=2

i=1 (b), j=2 (b) → match → i=2, j=3

i=2 (c), j=3 (g) → no match → j=4

i=2 (c), j=4 (d) → no match → j=5

i=2 (c), j=5 (c) → match → i=3, j=6

Now i == s.length() (3) → true.*/