class Solution {
    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int m = rowSum.length ;
        int n = colSum.length ;
        int[][] result = new int[m][n] ;
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++ ){
                int min = Math.min(rowSum[i] , colSum[j]) ;
                result[i][j] = min ;
                rowSum[i] -= min ;
                colSum[j] -= min ;
            }
        }
        return result ;
    }
}