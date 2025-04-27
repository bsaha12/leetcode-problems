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
    Map<Integer,Integer> map ;
    public List<Integer> rightSideView(TreeNode root) {
        map = new HashMap<>() ;
        dfs(root , 0 , 0) ;
        int size = map.size() ;
        List<Integer> list = new ArrayList<>() ;
        for(int i = 0 ; i < size ; i++){
            list.add(map.get(i)) ;
        }
        return list ;
    }

    public void dfs(TreeNode root , int x , int y){
        if(root == null) return ;
        int val = root.val ;
        map.putIfAbsent(y , val) ;
        dfs(root.right , x + 1 , y + 1) ;
        dfs(root.left , x - 1 , y + 1) ;
    }
}