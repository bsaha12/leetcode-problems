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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null ;

        int val = root.val ;
        int valP = p.val ;
        int valQ = q.val ;

        // advantage of binary search tree
        // // lies in between
        // if((val < valP && val > valQ) || (val > valP && val < valQ)) return root;

        // // self lca
        // if(val == valP || val == valQ ) return root ;

        // valP and valQ both is greater
        if(valP > val && valQ > val){
            return lowestCommonAncestor(root.right, p, q) ;
        }else if(valP < val && valQ < val){
            return lowestCommonAncestor(root.left, p, q) ;
        }else {
            return root;
        }

    }
}