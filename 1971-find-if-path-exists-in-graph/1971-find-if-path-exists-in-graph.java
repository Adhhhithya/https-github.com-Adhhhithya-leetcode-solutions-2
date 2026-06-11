class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        boolean vis[] = new boolean[n];
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            int s =edges[i][0];
            int d = edges[i][1];
            adj.get(s).add(d);
            adj.get(d).add(s);
        }
        return bfs(source,destination,adj,vis);
    }
    private static boolean bfs(int source,int dest,List<List<Integer>> adj,boolean vis[]){
        if(source==dest){
            return true;
        }
        Queue<Integer> q = new LinkedList<>();
        q.add(source);
        vis[source] = true;
        while(!q.isEmpty()){
            int curr = q.poll();
            for(int i : adj.get(curr)){
                if(vis[i]==false){
                    vis[i] = true;
                    q.add(i);
                    if(i==dest){
                        return true;
                    }
                }
            }
        }
        return false;
    }
}