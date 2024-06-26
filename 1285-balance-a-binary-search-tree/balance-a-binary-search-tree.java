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
    public TreeNode balanceBST(TreeNode root) {
        List<Integer> list = new ArrayList<>() ;
        inOrder(root , list) ;
        return makeTree(list , 0 , list.size() - 1) ;
    }//

    TreeNode makeTree(List<Integer> list , int start , int end ){
        if(start > end)
            return null ;

        int mid = (start + end ) / 2 ;
        TreeNode root = new TreeNode(list.get(mid) ) ;
        root.left = makeTree(list , start , mid - 1 ) ;
        root.right = makeTree(list , mid + 1 , end ) ;
        return root ;
    }///

    void inOrder(TreeNode root , List<Integer> list){
        if(root == null) return ;
        inOrder(root.left , list) ;
        list.add(root.val) ;
        inOrder(root.right , list) ;
    }//
}