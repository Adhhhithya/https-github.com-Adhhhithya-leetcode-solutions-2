class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int ini = image[sr][sc];
        int ans[][] = image;
        int del_row []={-1,0,1,0};
        int del_col[]={0,1,0,-1};
        dfs(sr,sc,image,ans,ini,color,del_row,del_col);
        return ans;
    }
    private static void dfs(int row,int col,int image[][],int ans[][],int ini,int color,int del_row[],int del_col[]){
        ans[row][col] = color;
        int n = image.length;
        int m = image[0].length;
        for(int i=0;i<4;i++){
            int nrow = row + del_row[i];
            int ncol = col + del_col[i];
            if(nrow>=0 && nrow<n &&
            ncol>=0 && ncol<m &&
            image[nrow][ncol]==ini &&
            ans[nrow][ncol]!=color){
                dfs(nrow,ncol,image,ans,ini,color,del_row,del_col);
            }
        }
    }
}