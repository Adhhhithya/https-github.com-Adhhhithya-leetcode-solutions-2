class Solution {
    public int uniquePaths(int m, int n) {
        int prev[] = new int[n];
        Arrays.fill(prev,0);
        for(int i=0;i<m;i++){
            int curr[] = new int [n];
            for(int j=0;j<n;j++){
                if(i==0 && j==0){
                    curr[j]=1;
                    continue;
                }
                int left = (j>0) ? curr[j-1]:0;
                int up = (i>0) ? prev[j]:0;
                curr[j] = left + up;
            }
            prev = curr;
        }
        return prev[n-1];
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