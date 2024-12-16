class Solution {
    public int uniquePathsWithObstacles(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] memo = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                memo[i][j] = -1;  // Initialize memo table
            }
        }
        return helper(grid, 0, 0, memo);
    }

    public int helper(int[][] grid, int row, int col, int[][] memo) {
        if (row >= grid.length || col >= grid[0].length || grid[row][col] == 1) return 0;
        if (row == grid.length - 1 && col == grid[0].length - 1) return 1;
        if (memo[row][col] != -1) return memo[row][col];  // Return memoized result
        
        int right = helper(grid, row, col + 1, memo);
        int down = helper(grid, row + 1, col, memo);
        
        memo[row][col] = right + down;
        return memo[row][col];
    }
}