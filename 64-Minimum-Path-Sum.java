class Solution {
    public int minPathSum(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int[][] dp=new int[m][n];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
        return helper(grid,0,0,dp);
    }
    public int helper(int[][] grid,int m,int n,int[][] dp){
        if(m==grid.length-1 && n==grid[0].length-1){
            return grid[m][n];
        }
        if(m>=grid.length || n>=grid[0].length){
            return Integer.MAX_VALUE;
        }
        
        if(dp[m][n]!=-1){
            return dp[m][n];
        }
        int ra=helper(grid,m,n+1,dp);
        int da=helper(grid,m+1,n,dp);
        dp[m][n]=grid[m][n]+Math.min(ra,da);
        return dp[m][n];
    }
}