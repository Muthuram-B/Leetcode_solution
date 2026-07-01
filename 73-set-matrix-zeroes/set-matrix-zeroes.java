class Solution {
    public void setZeroes(int[][] matrix) {
        
        boolean firstrow=false; boolean firstcol=false;
/* the logic is simple 
             first find if any zero in index 0 in firstrow and col then make it true
             then find zero from inner matrix and update the zeroindex or outermatrix
             eg if you find zero in mat[1][1] 
                   then outermatrix  mat[0][1] and mat[1][0] should be zero */
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]==0){
                    if(i==0) firstrow=true;
                    if(j==0) firstcol=true;

                    matrix[i][0]=0;
                    matrix[0][j]=0;
                }
            }
        }
/* this is the next step
          after making all possible zeros in outermatrix with the inner matriz
          then update zero in the inner matrix based on the outermatrix
          if the anyrow in outermatrix is zero then make those innerrow zero
          eg if mat[1][0] =0 then mat[1][1] and mat[1][2] is also 0*/
        for(int i=1;i<matrix.length;i++){
            for(int j=1;j<matrix[0].length;j++){
                if(matrix[i][0]==0 || matrix[0][j]==0) matrix[i][j]=0;
            }
        }
// fill the outermatrix if any zero are to be changed
        if(firstrow){
            for(int j=0;j<matrix[0].length;j++) matrix[0][j]=0;
                }

        if(firstcol){
            for(int i=0;i<matrix.length;i++) matrix[i][0]=0;
        }


    }
}