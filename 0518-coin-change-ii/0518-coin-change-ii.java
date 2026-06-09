class Solution {
    public int change(int amount, int[] coins) {
        int N = coins.length;
        long dp[][] = new long[N][amount+1];

        for(int i=0;i<=amount;i++){
            dp[0][i] = (i%coins[0]==0)?1:0;
        }

        for(int ind=1;ind<N;ind++){
            for(int t=0;t<=amount;t++){
                long not_take =  dp[ind-1][t];
                long take =0;
                if(coins[ind]<=t){
                    take =  dp[ind][t-coins[ind]];
                }
                dp[ind][t] = (not_take+take);
            }
        }
        return (int) dp[N-1][amount];
    }
}