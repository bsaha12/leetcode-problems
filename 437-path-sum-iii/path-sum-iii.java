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
    public int pathSum(TreeNode root, int targetSum) {
        Map<Long,Long> prefixSums = new HashMap<>() ;
        return helper(root, targetSum, 0L, prefixSums) ;
    }

    public int helper(TreeNode root, long targetSum, long currSum, Map<Long,Long> prefixSums){
        if(root == null) return 0 ;

        long val = (long) root.val ;
        int count = 0 ;
        currSum += val ;

        if(currSum == targetSum) count++ ;

        long prefixVal = currSum - targetSum ;

        count += prefixSums.getOrDefault(prefixVal, 0L) ;

        prefixSums.put(currSum , prefixSums.getOrDefault(currSum, 0L) + 1) ;

        count += helper(root.left, targetSum, currSum, prefixSums) ;
        count += helper(root.right, targetSum, currSum, prefixSums) ;


        prefixSums.put(currSum , prefixSums.getOrDefault(currSum, 0L) - 1) ;

        return count ;
    }
}