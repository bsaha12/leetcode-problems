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
    String str ;
    public String getDirections(TreeNode root, int startValue, int destValue) {
        findPath(root , startValue , new StringBuilder("")) ;
        char[] start = str.toCharArray() ;

        findPath(root , destValue , new StringBuilder("")) ;
        char[] dest = str.toCharArray() ;

        int minLen = Math.min( start.length , dest.length );
        int i = 0 ;
        for(i = 0 ; i < minLen ; i++){
            if(start[i] != dest[i]  ){
                break ;
            }
        }

        StringBuilder path = new StringBuilder() ;
        for(int j = i ; j < start.length ; j++){
            path.append('U') ;
        }
        for(int j = i ; j < dest.length ; j++){
            path.append( dest[j] ) ;
        }
        return path.toString() ;

    }//
    void  findPath(TreeNode root, int value, StringBuilder path){
        if(root == null) return ;
        if(root.val == value){
            str = path.toString() ;
            return ;
        } 

        findPath(root.left , value , path.append("L") ) ;
        path.deleteCharAt(path.length() - 1 ) ;
        findPath(root.right , value , path.append("R") ) ;
        path.deleteCharAt(path.length() - 1 ) ;
    }
}