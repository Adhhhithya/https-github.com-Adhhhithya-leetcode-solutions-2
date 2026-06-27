class Solution {
    public int search(int[] nums, int target) {
        return func(nums,0,nums.length-1,target);
    }
    private static int func(int arr[],int low,int high,int target){
        if(low>high){
            return -1;
        }
        int mid = (low+high)/2;
        if(arr[mid]==target){
            return mid;
        }else if(arr[mid]<target){
            return func(arr,mid+1,high,target);
        }else{
            return func(arr,low,mid-1,target);
        }
    }
}