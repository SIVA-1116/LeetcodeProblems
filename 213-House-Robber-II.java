class Solution {
    public int rob(int[] nums){
        int n=nums.length;
        if (n == 0) return 0;
        if (n == 1) return nums[0];

        int case1=helper(Arrays.copyOfRange(nums,1,n));

        int case2=helper(Arrays.copyOfRange(nums,0,n-1));

        return Math.max(case1,case2);
    }
    public int helper(int[] nums) {
        int n=nums.length;
        int[] dp=new int[n];
        Arrays.fill(dp,-1);
        return rob1(nums,n-1,dp);
    }
    public int rob1(int[] nums,int n,int[] dp){
        if(n<0) return 0;
        if(n==0) return nums[0];
        if(dp[n]!=-1) return dp[n];
        int skip=rob1(nums,n-1,dp)+0;
        int rob=rob1(nums,n-2,dp)+nums[n];
        dp[n]=Math.max(skip,rob);
        return dp[n];
    }
}