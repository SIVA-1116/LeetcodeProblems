class Solution {
    public void solveSudoku(char[][] board) {
        solve(board,0,0);
    }
    public boolean solve(char[][] board , int row,int col){
        if(row==board.length) return true;
        if(col==board[0].length){
            return solve(board, row+1,0);
            
        }
        if(board[row][col]!='.'){
            return solve(board,row,col+1);
            
        }
        for(char i='1';i<='9';i++){
            if(isValidate(board,row,col,i)){
                board[row][col]=i;
                if(solve(board,row,col+1)){
                    return true;
                }
                board[row][col]='.';
            }
        }
        return false;
    }
    public boolean isValidate(char[][] board,int row,int col,char num){
        for(int c=0;c<board[0].length;c++){
            if(board[row][c]==num){
                 return false;
            }
        }
        for(int r=0;r<board.length;r++){
            if(board[r][col]==num){
                return false;
            } 
        }
        int smi=(row/3)*3;
        int smj=(col/3)*3;
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(board[smi+i][smj+j]==num)
                return false;
            }
        }
        return true;
    }
}