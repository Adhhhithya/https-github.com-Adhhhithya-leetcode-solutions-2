class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int m = isConnected[0].length;
        List<List<Integer>> adjLs = new ArrayList<>();
        for(int i=0;i<n;i++){
            adjLs.add(new ArrayList<>());
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(isConnected[i][j]==1 && i!=j){
                    adjLs.get(i).add(j);
                    adjLs.get(j).add(i);
                }
            }
        }
        int cnt =0;
        boolean vis[] = new boolean[n+1];
        for(int i=0;i<n;i++){
            if(!vis[i]){
                cnt++;
                dfs(i,adjLs,vis);
            }
        }
        return cnt;
    }

    private static void dfs(int node,List<List<Integer>> adjLs,boolean vis[]){
        vis[node] = true;
        for(int i : adjLs.get(node)){
            if(!vis[i]){
                dfs(i,adjLs,vis);
            }
        }
    }
}