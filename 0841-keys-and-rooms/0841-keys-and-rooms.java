class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int v = rooms.size();
        boolean vis[] = new boolean[v];
        int cnt = bfs(0,vis,rooms);
        return cnt==v;
    }
    private static int bfs(int node,boolean vis[],List<List<Integer>> rooms){
        Queue<Integer> q = new LinkedList<>();
        int cnt =1;
        q.add(node);
        vis[node] = true;
        while(!q.isEmpty()){
            int curr = q.poll();
            for(int i:rooms.get(curr)){
                if(vis[i]==false){
                    cnt++;
                    vis[i]=true;
                    q.add(i);
                }
            }
        }
        return cnt;
    }
}