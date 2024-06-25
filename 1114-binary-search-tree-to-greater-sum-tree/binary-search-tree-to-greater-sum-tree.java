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
    public TreeNode bstToGst(TreeNode root) {
       convertBstToGst(root , 0) ;
       return root ;
    }
    int convertBstToGst(TreeNode root , int top){
        if(root == null) return 0 ;
        int right = convertBstToGst(root.right , top) ;
        int curr = root.val ;
        root.val = right + curr + top;
        int left = convertBstToGst(root.left , root.val) ;
        return left + right + curr ;
    }
}