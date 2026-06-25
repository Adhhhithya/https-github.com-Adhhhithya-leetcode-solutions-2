class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int i = find_target_ind(arr,x);
        int j = i+1;
        List<Integer> ans = new ArrayList<>();

        while(k>0 && i>=0 && j<arr.length){
            if(Math.abs(x-arr[i])<=Math.abs(x-arr[j])){
                ans.add(arr[i]);
                i--;
            }else{
                ans.add(arr[j]);
                j++;
            }
            k--;
        }

        while(k>0 && i>=0){
            ans.add(arr[i]);
            i--;
            k--;
        }

        while(k>0 && j<arr.length){
            ans.add(arr[j]);
            j++;
            k--;
        }
        Collections.sort(ans);
        return ans;
    }

    private static int find_target_ind(int arr[],int x){
        int n = arr.length;
        int start =0;
        int end = n-1;
        int ans =0;
        while(start<=end){
            int mid = (start+end)/2;
            if(arr[mid]==x){
                return mid;
            }else if(arr[mid]<x){
                ans = mid;
                start = mid+1;
            }else{
                end = mid -1;
            }
        }
        return ans;
    }
}