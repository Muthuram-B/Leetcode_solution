class Solution {
    public int nthUglyNumber(int n) {
        
        int[] ugly=new int[n];
        ugly[0]=1;
        
        int p2=0; int p3=0; int p5=0;
        for(int i=1;i<n;i++){

            int twomultiplier = ugly[p2]*2; //1*2=2 -> 2*2=4 -> 2*2=4 -> 4*2=8
            int threemultiplier = ugly[p3]*3;//1*3=3 -> 1*3=3 -> 2*3=6 -> 2*3=6
            int fivemultiplier =ugly[p5]*5; // 1*5=5 -> 1*5=5 -> 1*5=5 -> 2*2=4

        ugly[i] =Math.min(twomultiplier,Math.min(threemultiplier,fivemultiplier));

            if(ugly[i]==twomultiplier) p2++;
            if(ugly[i]==threemultiplier) p3++;
            if(ugly[i]==fivemultiplier) p5++;

        }
        return ugly[n-1];
    }
}