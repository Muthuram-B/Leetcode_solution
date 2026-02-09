class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        //it follows sliding window + freq mapping
        int[] pCount=new int[26];
        int[] sCount=new int[26];
        List<Integer> res =new ArrayList<>();
        
        for(char c:p.toCharArray()){
            pCount[c-'a']++;// it adds the freq of ele in p string
        }
        for(int i=0;i<s.length();i++){
             sCount[s.charAt(i)-'a']++; // it adds every ele to the scount array

             if(i>=p.length()) sCount[s.charAt(i-p.length())-'a']--;
 // it removes the ele if i exceeds p that is here the 3 ele  it remove the first ele
             if(Arrays.equals(pCount,sCount)) res.add(i-p.length()+1);

           //.equals method compares the length if same then check the ele at the
           // idx if both are same return the idx of the starting point             
            
        }
        return res;
    }
}