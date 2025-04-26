/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    TreeNode LCA ;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        helper(root , p , q) ;
        return LCA ;
    }

    public boolean helper(TreeNode root , TreeNode p , TreeNode q){
        if(root == null) return false ;

        boolean isCurrentValueMatching = root.val == p.val || root.val == q.val ;

        boolean left = helper(root.left , p , q) ;
        boolean right = helper(root.right , p , q) ;

        if(left && right) LCA = root ;
        else if(isCurrentValueMatching && (left || right )) LCA = root ;

        return isCurrentValueMatching || left || right ;
    }
}