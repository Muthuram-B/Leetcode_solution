class Solution {
    public void solveSudoku(char[][] board) {
        solve(board);
    }
    public static boolean solve(char[][] board){
        int n=board.length;
        int r=-1,c=-1;
        boolean emptyLeft=false;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]=='.'){
                    r=i;
                    c=j;
                    emptyLeft=true;
                    break;
                }
            }
            if(emptyLeft) break;
        }
        if(!emptyLeft) return true;

        for(char num='1';num<='9';num++){
            if(isSafe(board,r,c,num)){
                board[r][c]=num;
                if(solve(board)) return true;
                else  board[r][c]='.';
            }
        }
        return false;
    }
public static boolean isSafe(char[][] board,int r,int c,int num){
    for(int i=0;i<board.length;i++){
        if(board[r][i]==num) return false;
        if(board[i][c]==num) return false;
      

    }
   

    int sqrt=(int)Math.sqrt(board.length);
    int rowstart=r-(r%sqrt);
    int colstart=c-(c%sqrt);

    for(int i=rowstart;i<rowstart+sqrt;i++){
        for(int j=colstart;j<colstart+sqrt;j++){
            if(board[i][j]==num) return false;
        }
    }
    return true;
}
}