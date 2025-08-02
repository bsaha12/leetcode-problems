class Solution {
    int[][] cache ;
    public int uniquePaths(int m, int n) {
        cache = new int[m + 1][ n + 1] ;
        for(int[] arr : cache){
            Arrays.fill(arr , -1) ;
        }
        return helper(0 ,0 , m , n) ;
    }

    public int helper(int i ,int j , int m , int n){
        if( i == m - 1 && j == n -1  ) return 1 ;
        if( i == m || j == n) return 0 ;

        if(cache[i][j] != -1) return cache[i][j] ;

        return cache[i][j] = helper(i + 1 , j , m , n) + helper( i , j + 1 , m , n) ;
    }
}