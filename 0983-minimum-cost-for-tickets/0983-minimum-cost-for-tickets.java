class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int n = days.length;
        int dp[] = new int[n+1];
        dp[0] =0;
        for(int i=n-1;i>=0;i--){
            int one = costs[0] + dp[i+1];
            int seventhidx = next_idx(i,7,days,n);
            int seven = costs[1] + dp[seventhidx];
            int thirtyidx = next_idx(i,30,days,n);
            int thirty = costs[2] + dp[thirtyidx];
            dp[i]=Math.min(one,Math.min(seven,thirty));
        }
        return dp[0];
    }
    // private static int func(int ind,int days[],int costs[],int n,int dp[]){
    //     if(ind>=n) return 0;
    //     int one = costs[0] + func(ind+1,days,costs,n,dp);
    //     int seventhidx = next_idx(ind,7,days,n);
    //     int seven = costs[1] + func(seventhidx,days,costs,n,dp);
    //     int thirtyidx = next_idx(ind,30,days,n);
    //     int thirty = costs[2] + func(thirtyidx,days,costs,n,dp);
    //     return dp[ind]=Math.min(one,Math.min(seven,thirty));
    // }
    private static int next_idx(int ind,int duration, int days[],int n){
        int j =ind;
        int end = days[ind] + duration;
        while(j<n && days[j]<end){
            j++;
        }
        return j;
    }
}