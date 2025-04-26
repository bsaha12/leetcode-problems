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
    public int goodNodes(TreeNode root) {
        return helper(root , Integer.MIN_VALUE) ;
    }

    public int helper(TreeNode root , int max){
        if(root == null) return 0 ;
        int val = root.val ;
        int curr = max > val ? 0 : 1 ;
        max = Math.max(val , max) ;
        return curr + helper(root.left , max) + helper(root.right , max) ;
    }

}