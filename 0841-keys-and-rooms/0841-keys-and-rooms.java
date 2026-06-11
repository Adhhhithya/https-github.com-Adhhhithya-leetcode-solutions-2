class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int v = rooms.size();
        boolean vis[] = new boolean[v];
        return bfs(0,vis,rooms);
    }
    private static boolean bfs(int node,boolean vis[],List<List<Integer>> rooms){
        Queue<Integer> q = new LinkedList<>();
        q.add(node);
        vis[node] = true;
        while(!q.isEmpty()){
            int curr = q.poll();
            for(int i:rooms.get(curr)){
                if(vis[i]==false){
                    vis[i]=true;
                    q.add(i);
                }
            }
        }
        boolean ans = true;
        for(boolean X : vis){
            ans = ans & X;
        }
        return ans;
    }
}