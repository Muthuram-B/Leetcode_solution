class Solution {
    public int mySqrt(int x) {
        
        // double n=x;;
        // double root;
        // while(true){
        //     root=0.5*(n+(x/n));
        //     if(Math.abs(root-n)<1){
        //         break;
        //     }
        //     n=root;
        // }
        // return (int)root;


        if(x==0||x==1) return x;
        int s=0; int e=x;

        int ans=0;

        while(s<=e){
            int m=(s+e)/2;
            if(m*m==x) return m;
            if(m<=x/m){
                s=m+1;
                ans=m;
            }else e=m-1;
        }
        return ans;
    }
}