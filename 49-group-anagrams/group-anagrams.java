import java.math.BigInteger;
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
//         List<List<String>> list=new ArrayList<>();

//         HashMap<String> map=new HashMap<>();
// List<String> sublist=new ArrayList<>();
  
//      for(String str:strs){
//         String sorted=str.sort().toLowerCase();
//         map.put(sorted);
//      }
//      for(String str:strs){
//         if()
//      }
    

    if(strs==null || strs.length==0) return new ArrayList<>();

    // Map<String,List<String>> freqmap=new HashMap<>();

    // for(String str:strs){

    //     String freqstr=getFreqStr(str);

    //     if(freqmap.containsKey(freqstr)) freqmap.get(freqstr).add(str);

    //     else{
    //         List<String> s = new ArrayList<>();
    //         s.add(str);
    //         freqmap.put(freqstr,s);
    //     }
    // }
    // return new ArrayList<>(freqmap.values());
    // }


    // private String getFreqStr(String str){

    //     int[] freq=new int[26];

    //     for(char c:str.toCharArray()) freq[c-'a']++;

    //     StringBuilder freqstr=new StringBuilder("");
    //     char c='a';
    //     for(int i:freq){
    //         freqstr.append(c);
    //         freqstr.append(i);
    //         c++;
    //     }

    //     return freqstr.toString();
    // }



    /* a unique approach , mark every character of the alphabets to first 26 prime numbers for unique idenfication 
      then get each word from the string array and prod the numbers and character of each word to generate a unique number for that word and use it as key
      then check if the number is present if it is then add the respective word to that specific unique number 
      finally return the values of the unique numbers in group
*/
      int nos[]={2,3,5,7,11,13,17,19,23,29,31,37,41,43,47,53,59,61,67,71,73,79,83,89,97,101,103};

      Map<BigInteger,List<String>> map=new HashMap<>();
      for(String str:strs){
        BigInteger prod=BigInteger.ONE;
        for(int i=0;i<str.length();i++){
            //prod*=nos[str.charAt(i)-'a'];
            prod = prod.multiply(BigInteger.valueOf(nos[str.charAt(i) - 'a']));
        }
        if(map.containsKey(prod)) map.get(prod).add(str);

        else{
            map.put(prod,new ArrayList<String>());
            map.get(prod).add(str);
        }
      }

      List<List<String>> list=new ArrayList<List<String>>();
     for(List<String> res:map.values()) list.add(res);

     return list;
}
}