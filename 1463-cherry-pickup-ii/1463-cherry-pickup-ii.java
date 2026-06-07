class Solution {
    public int cherryPickup(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int dp[][][] = new int[n][m][m];
        for(int row1[][]:dp){
            for(int row2[]:row1){
                Arrays.fill(row2,-1);
            }
        }
        return func(0,0,m-1,grid,dp,n,m);
    }
    private static int func(int i,int j1,int j2,int a[][],int dp[][][],int n,int m){
        if(j1<0 ||j1>=m ||j2<0||j2>=m){
            return (int)(-1e9);
        }
        if(i==n-1){
            if(j1==j2){
                return a[i][j1];
            }else{
                return a[i][j1]+a[i][j2];
            }
        }
        if(dp[i][j1][j2]!=-1){
            return dp[i][j1][j2];
        }

        int maxi =0;
        for(int dj1=-1;dj1<=1;dj1++){
            for(int dj2=-1;dj2<=1;dj2++){
                if(j1==j2){
                    maxi = Math.max(maxi,a[i][j1]+func(i+1,j1+dj1,j2+dj2,a,dp,n,m));
                }else{
                    maxi = Math.max(maxi,a[i][j1]+a[i][j2]+func(i+1,j1+dj1,j2+dj2,a,dp,n,m));
                }
            }
        }

        return dp[i][j1][j2]=maxi;
    }
}