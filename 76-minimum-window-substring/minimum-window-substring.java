class Solution {
    public String minWindow(String s, String t) {
     if(s.length()<t.length()) return "";
     int[] freq=new int[128];
     for(char c:t.toCharArray()){
        freq[c]++;
     }   
     int left=0;int right=0;
     int needed=t.length();
     int minstart=0;
     int minLen=Integer.MAX_VALUE;

     while(right<s.length()){
        char r =s.charAt(right);
        if(freq[r]>0){
            needed--;
        }
            freq[r]--;
            right++;
        
        while(needed==0){
            if(right-left<minLen){
                minLen=right-left;
                minstart=left;
            }
            char l=s.charAt(left);
            freq[l]++;
            if(freq[l]>0)
            needed++;
            left++;
        }
     }
     if(minLen==Integer.MAX_VALUE){
        return "";
     }
     return s.substring(minstart,minstart+minLen);
    }
}