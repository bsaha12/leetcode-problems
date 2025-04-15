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
    int maxValue = Integer.MIN_VALUE ;
    public int maxPathSum(TreeNode root) {
        maxPathSumHelper(root ) ;
        return maxValue ;
    }

    public int maxPathSumHelper(TreeNode root){
        if(root == null) return 0 ;

        int rootValue = root.val ;
        int right = maxPathSumHelper(root.right) ;
        int left = maxPathSumHelper(root.left) ;

        int possibleMax = rootValue + Math.max(0 , right) + Math.max(left , 0) ;
        maxValue = Math.max(maxValue , possibleMax) ;

        return rootValue + Math.max(0 , Math.max(right , left)) ;
    }
}