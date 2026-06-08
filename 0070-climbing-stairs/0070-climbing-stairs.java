class Solution {
    public int climbStairs(int n) {
        int dp[] = new int[n+1];
        Arrays.fill(dp,-1);
        return func(n-1,dp);
    }
    private static int func(int ind,int dp[]){
    if(ind<=0){
        return 1;
    }
    if(dp[ind]!=-1){
        return dp[ind];
    }
    int One = func(ind-1,dp);
    int Two = func(ind-2,dp);
    return dp[ind]=One + Two;
}
}