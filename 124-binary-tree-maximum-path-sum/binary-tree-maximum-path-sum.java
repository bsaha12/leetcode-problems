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
        int[] result = new int[1] ;
        result[0] = Integer.MIN_VALUE ;
        maxPathSumHelper(root , result) ;
        return result[0] ;
    }

    public int maxPathSumHelper(TreeNode root , int[] result){
        if(root == null) return Integer.MIN_VALUE ;

        int rootValue = root.val ;
        int right = maxPathSumHelper(root.right , result) ;
        int left = maxPathSumHelper(root.left , result) ;

        result[0] = Math.max(result[0] , rootValue) ;
        result[0] = Math.max(result[0] , right) ;
        result[0] = Math.max(result[0] , left) ;

        if(right < 0 && left < 0){
            return rootValue ;
        }else if(right >= 0 && left < 0 ){
            int rightSum = right + rootValue ;
            result[0] = Math.max(rightSum , result[0]) ;
            return rightSum ;
        }else if(left >=0 && right < 0){
            int leftSum = left + rootValue ;
            result[0] = Math.max(leftSum , result[0]) ;
            return leftSum ;
        }else{
            int total = right + left + rootValue ;
            result[0] = Math.max(total , result[0]) ;
            return Math.max(right + rootValue , left + rootValue) ;
        }
    }
}