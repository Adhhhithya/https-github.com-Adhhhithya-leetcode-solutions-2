class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int chocs[] = new int[n];
        Arrays.fill(chocs,1);
        for(int i=1;i<n;i++){
            if(ratings[i]>ratings[i-1]){
                chocs[i] = chocs[i-1] +1;
            }
        }

        for(int i=n-2;i>=0;i--){
            if(ratings[i]>ratings[i+1]){
                chocs[i] = Math.max(chocs[i],chocs[i+1]+1);
            }
        }
        return Arrays.stream(chocs).sum();
    }
}