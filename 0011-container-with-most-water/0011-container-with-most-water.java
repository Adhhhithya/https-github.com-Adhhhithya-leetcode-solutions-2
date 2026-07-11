class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        int maxArea = 0;
        int l =0;
        int r = n-1;
        while(l<r){
            int width = r-l;
            int area = width*Math.min(height[l],height[r]);
            maxArea = Math.max(maxArea,area);
            if(height[l]<height[r]){
                l++;
            }else{
                r--;
            }
        }
        return maxArea;
    }
}