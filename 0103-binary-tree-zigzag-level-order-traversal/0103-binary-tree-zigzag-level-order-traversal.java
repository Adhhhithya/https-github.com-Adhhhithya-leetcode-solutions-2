/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root==null) return res;
        Queue<TreeNode> q = new LinkedList<>();
        boolean flag = true;
        q.add(root);

        while(!q.isEmpty()){
            int size = q.size();
            Integer[] level = new Integer[size];
            for(int i=0;i<size;i++){
                TreeNode node = q.poll();
                int ind = flag ? i : (size-i-1);
                level[ind] = node.val;
                if(node.left!=null){
                    q.add(node.left);
                }
                if(node.right!=null){
                    q.add(node.right);
                }
            }
            flag=!flag;
            res.add(Arrays.asList(level));
        }
        return res;
    }
}