class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int dp[][] = new int[n][2];
        for(int row[]:dp){
            Arrays.fill(row,-1);
        }
        return func(0,1,prices,dp,n);
    }
    private static int func(int ind,int buy,int arr[],int dp[][],int n){
        if(ind>=n) return 0;
        if(dp[ind][buy]!=-1){
            return dp[ind][buy];
        }
        int profit =0;
        if(buy==1){
            profit = Math.max(
                (-1)*arr[ind] +func(ind+1,0,arr,dp,n),
                func(ind+1,1,arr,dp,n)
            );
        }
        if(buy==0){
            profit = Math.max(
                arr[ind] + func(ind+2,1,arr,dp,n),
                func(ind+1,0,arr,dp,n)
            );
        }
        return dp[ind][buy] = profit;
    }
}