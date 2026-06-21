class Solution {
    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();
        int dp[][] = new int[m+1][n+1];
        for(int row[]:dp){
            Arrays.fill(row,-1);
        }
        return func(m-1,n-1,p,s,dp);
    }
    private static boolean func(int i,int j,String s1, String s2,int dp[][]){
        if(i<0 && j<0) return true;
        if(i<0 && j>=0) return false;
        if(j<0 && i>=0){
            for(int k=0;k<=i;k++){
                if(s1.charAt(k)!='*'){
                    return false;
                }
            }
            return true;
        }

        if(dp[i][j]!=-1){
            return dp[i][j]==1;
        }

        if(s1.charAt(i)==s2.charAt(j) || s1.charAt(i)=='?'){
            dp[i][j] = func(i-1,j-1,s1,s2,dp) ? 1 :0;
            return dp[i][j]==1;
        }

        if(s1.charAt(i)=='*'){
            boolean match = func(i-1,j,s1,s2,dp) || func(i,j-1,s1,s2,dp);
            dp[i][j] = match ? 1 :0;
            return match;
        }else{
            dp[i][j]=0;
            return false;
        }
    }
}