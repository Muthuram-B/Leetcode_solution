class Solution {
    public int nthUglyNumber(int n) {
        
        int[] ugly=new int[n];
        ugly[0]=1;
        
        int p2=0; int p3=0; int p5=0;
        for(int i=1;i<n;i++){

            int twomultiplier = ugly[p2]*2;
            int threemultiplier = ugly[p3]*3;
            int fivemultiplier =ugly[p5]*5;

        ugly[i] =Math.min(twomultiplier,Math.min(threemultiplier,fivemultiplier));

            if(ugly[i]==twomultiplier) p2++;
            if(ugly[i]==threemultiplier) p3++;
            if(ugly[i]==fivemultiplier) p5++;

        }
        return ugly[n-1];
    }
}