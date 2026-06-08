class Solution {
    public boolean stoneGame(int[] piles) {
        int n = piles.length;
        int dp[][] = new int[n][n];
        for(int i=n-1;i>=0;i--){
            for(int j=i;j<n;j++){
                if(i==j){
                    dp[i][j] =piles[i];
                    continue;
                }
                int left = piles[i] - dp[i+1][j];
                int right = piles[j] - dp[i][j-1];
                dp[i][j] = Math.max(left,right);
            }
        }
        if(dp[0][n-1]>0){
            return true;
        }else{
            return false;
        }
    }
    // private static int func(int i,int j,int arr[],int dp[][],int n){
    //     if(i>j) return 0;
    //     if(dp[i][j]!=-1){
    //         return dp[i][j];
    //     }
    //     int left = arr[i] - func(i+1,j,arr,dp,n);
    //     int right = arr[j] - func(i,j-1,arr,dp,n);
    //     return dp[i][j] = Math.max(left,right);
    // }
}