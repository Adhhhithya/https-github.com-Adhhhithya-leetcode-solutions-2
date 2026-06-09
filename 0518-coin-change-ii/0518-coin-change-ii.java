class Solution {
    public int change(int amount, int[] coins) {
        int N = coins.length;
        long prev[] = new long [amount+1];

        for(int i=0;i<=amount;i++){
            prev[i] = (i%coins[0]==0)?1:0;
        }

        for(int ind=1;ind<N;ind++){
            long curr[] = new long [amount+1];
            for(int t=0;t<=amount;t++){
                long not_take =  prev[t];
                long take =0;
                if(coins[ind]<=t){
                    take =  curr[t-coins[ind]];
                }
                curr[t] = (not_take+take);
            }
            prev = curr;
        }
        return (int) prev[amount];
    }
}