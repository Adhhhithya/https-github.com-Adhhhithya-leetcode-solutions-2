class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int prev2 =0;
        int prev = nums[0];
        for(int i=1;i<n;i++){
            int pick = nums[i];
            if(i>1){
                pick+=prev2;
            }
            int not_pick = prev;
            int curr = Math.max(pick,not_pick);
            prev2 = prev;
            prev = curr;
        }
        return prev;
    }
}