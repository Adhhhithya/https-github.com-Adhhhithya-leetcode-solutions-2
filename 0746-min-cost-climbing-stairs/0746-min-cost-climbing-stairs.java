class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int dp[] = new int[n+1];
        Arrays.fill(dp,-1);
        return Math.min(func(n-1,cost,dp),func(n-2,cost,dp));
    }
    private static int func(int ind,int a[],int dp[]){
        if(ind==0) return a[0];
        if(ind==1) return a[1];
        if(dp[ind]!=-1){
            return dp[ind];
        }
        int one =  func(ind-1,a,dp);
        int two = func(ind-2,a,dp);
        return dp[ind]=a[ind]+ Math.min(one,two);
    }
}