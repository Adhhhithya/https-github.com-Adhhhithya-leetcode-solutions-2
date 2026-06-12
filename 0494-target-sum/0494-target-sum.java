class Solution {
    public static int mod = (int) 1e9 +7;
    public int findTargetSumWays(int[] nums, int target) {
        int ans = count_partition_diff(nums,Math.abs(target),nums.length);
        return ans;
    }
    public static int count_partition_diff(int nums[],int diff,int n){
        int total_sum =0;
        for(int i=0;i<n;i++) total_sum+=nums[i];
        if(total_sum-diff<0 || (total_sum-diff)%2==1) return 0;
        int s2 = (total_sum-diff)/2;
        int dp[][] = new int[n][s2+1];
        for(int row[]:dp) Arrays.fill(row,-1);
        return func(n-1,s2,nums,dp);
    }
    public static int func(int ind,int sum,int arr[],int dp[][]){
        if(ind==0){
            if(sum==0 && arr[0]==0) return 2;
            if(sum==0 || sum==arr[0]) return 1;
            return 0;
        }
        if(dp[ind][sum]!=-1) return dp[ind][sum];
        int np = func(ind-1,sum,arr,dp);
        int p=0;
        if(arr[ind]<=sum){
            p = func(ind-1,sum-arr[ind],arr,dp);
        }
        return dp[ind][sum] = (p+np);
    }
}