class Solution {
    public List<List<String>> solveNQueens(int n) {
        boolean[][] grid=new boolean[n][n];
        List<List<String>> solution=new ArrayList<>();
        solve(grid,0,solution);
        return solution;
    }
    public void solve(boolean[][] grid,int row,List<List<String>> solution){
        if(row==grid.length){
            solution.add(display(grid));
            return;
        }
        for(int col=0;col<grid.length;col++){
            if(isSafe(grid,row,col)){
                grid[row][col]=true;
                solve(grid,row+1,solution);
                grid[row][col]=false;
            }
        }
    }
    public List<String> display(boolean[][] grid){
        List<String> list=new ArrayList<>();
        for(boolean[] r:grid){
            StringBuilder str=new StringBuilder();
            for(boolean val:r){
                if(val){
                    str.append(\Q\);
                }else{
                    str.append(\.\);
                }
            }
            list.add(str.toString());
        }
        return list;
    }
    public boolean isSafe(boolean[][] grid,int row,int col){
        for(int i=row-1;i>=0;i--){
            if(grid[i][col]==true){
                return false;
            }
        }
        for(int i=row-1,j=col+1;i>=0 && j<grid.length;i--,j++){
            if(grid[i][j]==true){
                return false;
            }
        }
        for(int i=row-1,j=col-1;i>=0 && j>=0;i--,j--){
            if(grid[i][j]==true){
                return false;
            }
        }
        return true;
    }
}