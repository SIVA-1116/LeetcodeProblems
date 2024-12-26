class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        int[] dp=new int[n];
        Arrays.fill(dp,-1);
        return helper(nums,n-1,dp);
    }
    public int helper(int[] nums,int n,int[] dp){
        if(n<0) return 0;
        if(n==0) return nums[0];
        if(dp[n]!=-1) return dp[n];
        int ra=helper(nums,n-1,dp)+0;
        int la=helper(nums,n-2,dp)+nums[n];
        dp[n]=Math.max(la,ra);
        return dp[n];
    }
}