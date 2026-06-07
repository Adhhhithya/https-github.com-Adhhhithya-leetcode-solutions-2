class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int dp[][][] = new int[n][2][3];
        for(int row1[][]:dp){
            for(int row2[]:row1){
                Arrays.fill(row2,-1);
            }
        }
        return func(0,1,2,prices,dp,n);
    }
    private static int func(int ind,int buy,int cap,int a[],int dp[][][],int n){
        if(ind==n){
            return 0;
        }
        if(cap==0){
            return 0;
        }
        if(dp[ind][buy][cap]!=-1){
            return dp[ind][buy][cap];
        }
        int profit = 0;
        //buy
        if(buy==1){
            profit = Math.max(
                (-1)*a[ind] + func(ind+1,0,cap,a,dp,n), //buy
                func(ind+1,1,cap,a,dp,n) //not buy
            );
        }

        //sell
        if(buy==0){
            profit = Math.max(
                a[ind] + func(ind+1,1,cap-1,a,dp,n), //sell
                func(ind+1,0,cap,a,dp,n)
            );
        }
        return dp[ind][buy][cap] = profit;
    }
}