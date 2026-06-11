/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if(node==null) return null;
        HashMap<Node,Node> vis = new HashMap<>();
        Queue<Node> q = new LinkedList<>();
        Node cloneStart = new Node(node.val);
        vis.put(node,cloneStart);
        q.add(node);

        while(!q.isEmpty()){
            Node curr = q.poll();
            Node currClone = vis.get(curr);

            for(Node neighbor : curr.neighbors){
                if(!vis.containsKey(neighbor)){
                    Node cloneNeighbor = new Node(neighbor.val);
                    vis.put(neighbor,cloneNeighbor);
                    q.add(neighbor);
                    currClone.neighbors.add(cloneNeighbor);
                }else{
                    currClone.neighbors.add(vis.get(neighbor));
                }
            }
        }
        return cloneStart;
        
    }
}