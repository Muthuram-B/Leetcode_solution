class NumMatrix {
private int[][] prefix;
    public NumMatrix(int[][] matrix) {
        if(matrix==null || matrix.length==0|| matrix[0].length==0) return;

        int m=matrix.length;
        int n=matrix[0].length;
        prefix=new int[m][n];
         /* here it uses the prefixsum to calculate the values in the matrix
         that it finds the sum of each element for every matrix idx and  add the top,left and topleft ele is subracted beacause eg 3 0
                                     5  6   here the sum of mat[2][2]= 3+8+6-3(which is added with both 3+0 and 5+3 so we subtract once)=14*/
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int top=(i>0)?prefix[i-1][j]:0;
                int left=(j>0)?prefix[i][j-1]:0;
                int topleft=(i>0 && j>0)?prefix[i-1][j-1]:0;
                   // this is repeated for each ele and it is continued for each idx
                prefix[i][j]=matrix[i][j]+top+left-topleft;


            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        /* this takes the ele of particular mat[i][j] to certain mat[i][j]
        it takes the total which is the end of mat and top which is the remaining part 
        and left which is the left part  and topleft is added beause it is used twice
        so by this we find the sum of the particular idx of the matix in the whole matrix*/
        int total=prefix[row2][col2];
        int top=(row1>0)?prefix[row1-1][col2]:0;
        int left=(col1>0)?prefix[row2][col1-1]:0;
        int topleft=(row1>0 && col1>0)?prefix[row1-1][col1-1]:0;

        return total-top-left+topleft;

    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */