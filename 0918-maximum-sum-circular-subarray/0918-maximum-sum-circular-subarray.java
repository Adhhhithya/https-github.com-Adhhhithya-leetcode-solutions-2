class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int n = nums.length;
        int globalMax = nums[0];
        int globalMin = nums[0];
        int currMax = 0;
        int currMin = 0;
        int total =0;
        
        for(int i=0;i<n;i++){
            currMax = Math.max(currMax+nums[i],nums[i]);
            currMin = Math.min(currMin+nums[i],nums[i]);
            globalMax = Math.max(globalMax,currMax);
            globalMin = Math.min(globalMin,currMin);
            total += nums[i];

        }
        
        return (globalMax>0) ? Math.max(globalMax,total-globalMin):globalMax;
    }
}