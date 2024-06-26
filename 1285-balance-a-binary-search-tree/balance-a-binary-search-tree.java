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
        int[] arr = new int[list.size() ] ;
        int i = 0 ;
        for(int num : list){
            arr[i]= num ;
            i++ ;
        }
        return makeTree(arr , 0 , arr.length - 1) ;
    }//

    TreeNode makeTree(int[] arr , int start , int end ){
        if(start > end)
            return null ;

        int mid = (start + end ) / 2 ;
        TreeNode root = new TreeNode(arr[mid] ) ;
        root.left = makeTree(arr , start , mid - 1 ) ;
        root.right = makeTree(arr , mid + 1 , end ) ;
        return root ;
    }///

    void inOrder(TreeNode root , List<Integer> list){
        if(root == null) return ;
        inOrder(root.left , list) ;
        list.add(root.val) ;
        inOrder(root.right , list) ;
    }//
}