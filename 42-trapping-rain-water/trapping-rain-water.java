class Solution {
    public int trap(int[] height) {
    //     int n=height.length;
    //     if(n==0) return 0;

    //     int[] leftmax=new int[n];
    //     int[] rightmax=new int[n];
    //     leftmax[0]=height[0];
    //     rightmax[n-1]=height[n-1];

    //     for(int i=1;i<n;i++) leftmax[i]=Math.max(leftmax[i-1],height[i]);
    //     // this loop continuously store the max left and store in the leftmax array
    //     // it also doesnt check the entire array again and again it checks the previously 
    //     //updated value and store them in the respective index 
    //     // eg leftmax ={0,0,1,1,2,2,2,2,3,3,3,3}
    //     for(int i=n-2;i>=0;i--) rightmax[i]=Math.max(rightmax[i+1],height[i]);
    //      // rightmax={3,3,3,3,3,3,3,2,2,2,1,0}
    //     int totalwater=0;
    //     for(int i=0;i<n;i++) totalwater+=Math.min(leftmax[i],rightmax[i])-height[i];

    //     return totalwater;
    //     // to find total units of water we find the min index of left and right eg
    //     // for index 1 the leftmax=1 and rightmax=3 min=1  and then its height - (-1)
    //     // 1-1=0  and then for index 2  ,leftmax=1 rightmax=3  and its height -(0)
    //     // 1-0=1 and idex 2 has 1 unit of water and it goes on
    // }

    int water=0; int i=0; int j=height.length-1;
    int lmax=0,rmax=0;
    while(i<j){
        /*each and every time it caluculates the lmax and rmax and then check 
        the height of both inorder to avoid water spill so if heigth[i] < j then 
        we do i++ and then add the water unit if less then add at the end*/
        lmax=Math.max(lmax,height[i]);
        rmax=Math.max(rmax,height[j]);
        if(height[i]<=height[j]){
             water+=Math.min(lmax,rmax)-height[i];
             i++;
        } 
        else {
            water+=Math.min(lmax,rmax)-height[j];
            j--;
        }
    }
    

    return water;
}
}