class Solution {
    int[][] matrix ;
    long[] cache ;
    public long mostPoints(int[][] questions) {
        matrix = questions ;
        int n = questions.length ;
        cache = new long[n + 1] ;
        Arrays.fill(cache , -1) ;
        cache[n] = 0 ;
        return helper(0) ;
    }
    public long helper(int i){ // 2
        int n = matrix.length ;
        if(cache[i] != -1) return cache[i] ;

        long nonChosen = helper(i + 1) ;
        int nI = i + 1 ; // 3
        int bP = matrix[i][1] ; // 2
        while(nI < n && nI <= i + bP){ // 3 <= 4 , 4 <= 4
            nI++ ;
        }
        // nI -> 5
        long chosen = matrix[i][0] + helper(nI) ;
        return cache[i] = Math.max(chosen , nonChosen) ;
    }
}