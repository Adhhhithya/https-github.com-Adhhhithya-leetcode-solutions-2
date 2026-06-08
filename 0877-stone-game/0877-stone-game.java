class Solution {
    public boolean stoneGame(int[] piles) {
        int n = piles.length;
        int dp[][] = new int[n][n];
        for(int row[]:dp){
            Arrays.fill(row,-1);
        }
        int net_margin = func(0,n-1,piles,dp,n);
        return (net_margin >0);
    }
    private static int func(int i,int j,int arr[],int dp[][],int n){
        if(i>j) return 0;
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int left = arr[i] - func(i+1,j,arr,dp,n);
        int right = arr[j] - func(i,j-1,arr,dp,n);
        return dp[i][j] = Math.max(left,right);
    }
}