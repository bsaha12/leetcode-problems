class Solution {
    // int[][] cache ;
    // char[] sA , tA ;
    public int numDistinct(String s, String t) {
        char[] sA = s.toCharArray() ;
        char[] tA = t.toCharArray() ;

        int m = sA.length ;
        int n = tA.length ;
        // cache = new int[m][n] ;
        // for(int[] arr : cache) Arrays.fill(arr , -1) ;
        // return helper(0 , 0) ;

        int[] prev = new int[n + 1] ;
        prev[n] = 1;
        for(int i = m - 1; i >= 0 ; i-- ){
            int[] curr = new int[ n + 1] ;
            curr[n] = 1 ;;
            for(int j = n - 1 ; j >= 0 ; j--){
                char ch1 = sA[i] ;
                char ch2 = tA[j] ;

                int result = 0 ;
                if(ch1 == ch2){
                    result += prev[j + 1] ;
                }  

                result += prev[j];

                curr[j] = result ;
            }
            prev = curr ;
        }

        return prev[0] ;
    }

    // public int helper(int i , int j){
    //     if( j == tA.length) return 1 ;
    //     if(i == sA.length || j == tA.length) return 0 ;

    //     if(cache[i][j] == -1){
    //         char ch1 = sA[i] ;
    //         char ch2 = tA[j] ;

    //         int result = 0 ;
    //         if(ch1 == ch2){
    //           result += helper(i + 1 , j + 1  ) ;
    //         }

    //         result += helper(i + 1 , j) ;
    //         cache[i][j] = result ;
    //     }

    //     return cache[i][j] ;
    // }
}