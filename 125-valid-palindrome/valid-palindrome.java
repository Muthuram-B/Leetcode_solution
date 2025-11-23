class Solution {
    public boolean isPalindrome(String s) {
        int left=0;
        int right= s.length()-1;
        while(left<right){
            while(left<right && !Character.isLetterOrDigit(s.charAt(left))) left++;/*skips the unwanted spaces and other special character*/
            while(left<right && !Character.isLetterOrDigit(s.charAt(right))) right--;

             if(Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {return false;}/*It checks that from the first and last using an two pointer approach if ther=y arent equal then false else it is palindrome*/
                   left++;
             right--;
        }
        return true;
    }
}