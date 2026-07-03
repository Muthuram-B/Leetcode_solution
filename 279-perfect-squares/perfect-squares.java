class Solution {
    public int numSquares(int n) {
        /* a more optimal approach for the problem is using lagranges four square theorem and legenders three square theorem.
        wht it actually means a lagranges 4 square theorem tells a number always has
        4 squares that sum to that number exactly 
           eg: even if its 3 = 1^2+1^2+1^2+0^2 ; here 0 is not mandatory so to reduce
           for 3 number we go for legenders 3 square theorem
        wht legenders 3 square theorem tells if a number is not of a form, proof
           n=4^a(8b+7) then it requires 4 numbers
           Finding (a) and (b) for (n = 28)
           Count how many times 28 divides by 4:(28 div 4 = 7)(It divides evenly 1 time)
           Can 7 be divided by 4? No.Therefore, (a = 1).
           Set up the remaining part:The remaining number is (7).
           We set it equal to the core formula: (8b + 7 = 7)
           Solve for (b):Subtract 7 from both sides: (8b = 0) Divide by 8: (b = 0).Conclusion for 28:(a = 1, b = 0) Written out: (4^1 *(8(0) + 7) =4*7 = 28.Since it fits the formula, 28 requires 4 squares (28 = 16 + 4 + 4 + 4).
           (Note:And if this not satifies it is always a 3 )

           Similarly for 1 tht is a perfect square 6^2 =36 so return 1;

           Similarly for  2  we must have 2 numbers right so ,
              a*a+b*b =n ->  b*b=n-a*a -> b=sqrt(n-a*a)
               eg n=37 b=sqrt(37-1)-> b=6 and then b*b+a*a=n or b*b(6*6)=n(37)-a*a(1)
               so true always 2   

               THis is the core math logic*/

            int sqrtval=(int) Math.sqrt(n);

            if((sqrtval*sqrtval)==n) return 1;

            while(n%4==0) 
                n/=4;                    //4^a
                if((n%8)==7) return 4;   //(8b+7)%8= 8b%8+7%8(0+7)==7
            

            for(int i=1;i*i<=n;i++){
                int a=i*i;
                int b=(int) Math.sqrt(n-a);
                if(b*b == n-a) return 2;
            }

            return 3;
    }
}