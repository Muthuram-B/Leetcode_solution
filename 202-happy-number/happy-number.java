class Solution {
    public boolean isHappy(int n) {
/* a happy number is a number that keeps on repeating until it is one and also it will go on infinte loop 
when to stop : if you encounter same number in a hashset then just return false
*/  
        Set<Integer> set =new HashSet<>();
        while(true){
          
          int sum=0;
          while(n!=0){
            sum+=Math.pow(n%10,2.0);
            n/=10;
          }

          if(sum==1) return true;//  a happy number

          n=sum;
          if(set.contains(n)) return false;// that is duplicate 

          set.add(n);


        }
    }
}