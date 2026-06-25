class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int i = findFloorInd(arr,x);
        int j = i+1;
        List<Integer> temp = new ArrayList<>();
        while(k>0 && i>=0 && j<arr.length){
            if(Math.abs(x - arr[i])<= Math.abs(x - arr[j])){
                temp.add(arr[i]);
                i--;
            }else{
                temp.add(arr[j]);
                j++;
            }
            k--;
        }
        while(k>0 && i>=0){
            temp.add(arr[i]);
            i--;
            k--;
        }
        while(k>0 && j<arr.length){
            temp.add(arr[j]);
            j++;
            k--;
        }
        Collections.sort(temp);
        return temp;
    }

    private static int findFloorInd(int arr[],int x){
        int start = 0;
        int end = arr.length -1;
        int ans =0;
        while(start<=end){
            int mid = (start+end)/2;
            if(arr[mid]==x){
                return mid;
            }else if(arr[mid]<x){
                ans = mid;
                start = mid + 1;
            }else{
                end = mid -1;
            }
        }
        return ans;
    }
}