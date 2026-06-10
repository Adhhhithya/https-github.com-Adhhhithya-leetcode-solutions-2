class Solution {
    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if(sum%2==1) return false;
        return func(nums,sum/2);
    }
    private static boolean func(int arr[],int k){
        int n = arr.length;
        boolean prev[] = new boolean[k+1];
        if(arr[0]<=k){
            prev[arr[0]]=true;
        }
        for(int i=1;i<n;i++){
            boolean curr[] = new boolean[k+1];
            curr[0] = true;
            for(int target=1;target<=k;target++){
                boolean not_take = prev[target];
                boolean take = false;
                if(arr[i]<=target){
                    take = prev[target-arr[i]];
                }
                curr[target] = not_take || take;
            }
            prev = curr;
        }
        return prev[k];
    }
}