class Solution {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int dp[][] = new int[n][2];
        for(int row[]:dp){
            Arrays.fill(row,-1);
        }
        return func(0,1,prices,dp,n,fee);
    }

    private static int func(int ind,int buy,int a[],int dp[][],int n, int fee){
        if(ind==n){
            return 0;
        }
        if(dp[ind][buy]!=-1){
            return dp[ind][buy];
        }
        int profit =0;
        if(buy==1){
            profit = Math.max(
                (-1)*a[ind] + func(ind+1,0,a,dp,n,fee),
                func(ind+1,1,a,dp,n,fee)
            );
        }

        if(buy==0){
            profit = Math.max(
                a[ind] - fee + func(ind+1,1,a,dp,n,fee),
                func(ind+1,0,a,dp,n,fee)
            );
        }
        return dp[ind][buy]=profit;
    }
}