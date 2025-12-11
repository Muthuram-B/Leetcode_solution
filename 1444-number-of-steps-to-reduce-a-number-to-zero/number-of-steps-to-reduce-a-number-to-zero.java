class Solution {
    public int numberOfSteps(int num) {
    //     return helper(num,0);
    // }
    // private int helper(int num,int steps){
    //     if(num==0) return steps;

    //     if(num%2==0) return helper(num/2,steps+1);

    //     return helper(num-1,steps+1);
    // }

    if(num==0) return 0;
    if(num%2==0) return 1+numberOfSteps(num/2);

    return 1+numberOfSteps(num-1);
}
}