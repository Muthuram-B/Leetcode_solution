class Solution {
    public int gcdOfOddEvenSums(int n) {


     int sumodd=n*n;
     int sumeven=n*(n+1);

     return gcd(sumodd,sumeven);  

    }
    private static int gcd(int a,int b){

        while(b!=0){
            int rem=a%b;
            a=b;
            b=rem;
        }
        return a;
    }
}