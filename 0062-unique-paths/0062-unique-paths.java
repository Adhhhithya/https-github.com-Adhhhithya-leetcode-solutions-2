class Solution {
    public int uniquePaths(int m, int n) {
        int dp[][] = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==0 && j==0){
                    dp[i][j]=1;
                    continue;
                }
                int left = (j>0) ? dp[i][j-1]:0;
                int up = (i>0) ? dp[i-1][j]:0;
                dp[i][j] = left + up;
            }
        }
        return dp[m-1][n-1];
    }
    // private static int func(int i,int j,int dp[][]){
    //     if(i==0 && j==0) return 1;
    //     if(i<0 || j<0) return 0;
    //     if(dp[i][j]!=-1){
    //         return dp[i][j];
    //     }
    //     int left = func(i,j-1,dp);
    //     int up = func(i-i,j,dp);
    //     return dp[i][j] = left + up;
    // }
}