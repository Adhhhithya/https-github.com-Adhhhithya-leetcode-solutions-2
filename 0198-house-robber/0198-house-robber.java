class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int dp[] = new int[n+1];
        Arrays.fill(dp,-1);
        return func(n-1,nums,dp);
    }
    private static int func(int ind,int arr[],int dp[]){
        if(ind==0) return arr[0];
        if(ind<0) return 0;
        if(dp[ind]!=-1){
            return dp[ind];
        }
        int pick = arr[ind] + func(ind-2,arr,dp);
        int not_pick = func(ind-1,arr,dp);
        return dp[ind]=Math.max(pick,not_pick);
    }
}