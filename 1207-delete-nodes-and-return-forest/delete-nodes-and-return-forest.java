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
    Set<Integer> set ;
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        List<TreeNode> list = new ArrayList<>() ;
        set = new HashSet<>() ;
        for(int i : to_delete){
            set.add(i) ;
        }
        findForests(root , list , true) ;
return list ;
    }///
    void findForests(TreeNode root , List<TreeNode> list , boolean isTopDeleted ){
        if(root == null) return ;

        int val = root.val ;
        boolean currNodeToBeDeleted = set.contains(val) ? true : false ;

        if(isTopDeleted && !currNodeToBeDeleted){
            list.add(root) ;
        }

        findForests(root.left , list , currNodeToBeDeleted) ;
        findForests(root.right , list , currNodeToBeDeleted) ;

        if(root.right != null && set.contains(root.right.val) ){
            root.right = null ;
        }
        if(root.left != null && set.contains(root.left.val) ){
            root.left = null ;
        }
    }
}