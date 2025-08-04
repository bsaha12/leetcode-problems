class Solution {
    int[][] cache ;
    char[] sA , tA ;
    public int numDistinct(String s, String t) {
        sA = s.toCharArray() ;
        tA = t.toCharArray() ;

        int m = sA.length ;
        int n = tA.length ;
        cache = new int[m][n] ;
        for(int[] arr : cache) Arrays.fill(arr , -1) ;

        return helper(0 , 0) ;
    }

    public int helper(int i , int j){
        if( j == tA.length) return 1 ;
        if(i == sA.length || j == tA.length) return 0 ;

        if(cache[i][j] == -1){
            char ch1 = sA[i] ;
            char ch2 = tA[j] ;

            int result = 0 ;
            if(ch1 == ch2){
              result += helper(i + 1 , j + 1  ) ;
            }

            result += helper(i + 1 , j) ;
            cache[i][j] = result ;
        }

        // System.out.print( "( " + i + " , " + j + " ) -> ") ;
        // System.out.println(cache[i][j] ) ;

        return cache[i][j] ;
    }
}