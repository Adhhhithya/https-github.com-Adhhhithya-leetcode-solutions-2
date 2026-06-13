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
    public int maxPathSum(TreeNode root) {
        int maxi[] = {Integer.MIN_VALUE};
        path_sum(root,maxi);
        return maxi[0];
    }
    private static int path_sum(TreeNode root,int maxi[]){
        if(root==null) return 0;
        int left_sum = Math.max(0,path_sum(root.left,maxi));
        int right_sum = Math.max(0,path_sum(root.right,maxi));
        maxi[0] = Math.max(maxi[0],root.val+left_sum+right_sum);
        return root.val + Math.max(left_sum,right_sum);
    }
}