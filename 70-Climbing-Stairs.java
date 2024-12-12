class Solution {
    public int climbStairs(int n) {
        if(n==1||n==2)
        {
            return n;
        }
        int []x=new int[n+1];
        x[1]=1;
        x[2]=2;
        for(int i=3;i<=n;i++){
            x[i]=x[i-1]+x[i-2];
        }
        return x[n];
    }
}