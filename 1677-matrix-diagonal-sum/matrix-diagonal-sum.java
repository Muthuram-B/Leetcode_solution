class Solution {
    public int diagonalSum(int[][] mat) {
        int n=mat.length;
        int diagsum=0; int j=n-1;
        for(int i=0;i<mat.length;i++){
            
                diagsum+=mat[i][i];
                //j++;

                diagsum+=mat[i][j--];
        }
                if(n%2!=0) diagsum-= mat[n/2][n/2];
        
    
    return diagsum;
    }
    
}