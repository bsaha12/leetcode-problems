class Solution {
    int[][] cache, matrix;

    public int countSquares(int[][] mat) {
        matrix = mat;
        int m = matrix.length;
        int n = matrix[0].length;
        cache = new int[m][n];
        for (int[] arr : cache)
            Arrays.fill(arr, -1);

        int result = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 1) {
                    result += helper(i, j);
                }
            }
        }

        return result;
    }

    public int helper(int i , int j){
        if(i >= matrix.length || j >= matrix[0].length){
            return 0 ;
        }

        if(cache[i][j] == -1){
            if(matrix[i][j] == 0){
                cache[i][j] = 0 ;
            }else{
                int right = helper(i , j + 1) ;
                int bottom = helper( i  + 1 , j) ;
                int corner = helper(i + 1 , j + 1) ;
                cache[i][j] = 1 + Math.min(Math.min(right , bottom) , corner );
            }
        }
        return cache[i][j] ;
    }
}