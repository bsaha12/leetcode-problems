class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int len = strs.length ;
        int[][] counts = new int[len][2] ;
        for(int i = 0 ; i < len ; i++){
            String str = strs[i] ;
            int zeroes = 0 ;
            int ones = 0 ;
            int length = str.length() ;
            for(int j = 0 ; j < length ; j++){
                if(str.charAt(j) == '1' ){
                    ones++ ;
                }else{
                    zeroes++ ;
                }
            }
            counts[i][0] = zeroes ;
            counts[i][1] = ones ;
        }

        // return helper(counts , 0 , m , n) ;
        int[][] prev = new int[m + 1][n + 1] ;
        for(int x = len - 1 ; x >= 0 ; x-- ){
            int[][] curr = new int[m + 1][n + 1] ;
            int zC = counts[x][0] ;
            int oC = counts[x][1] ;
            for(int i = 0 ; i <= m ; i++){
                for(int j = 0 ; j <= n ; j++){
                    int result = 0 ;
                    int chosen = 0 ;
                    if( i - zC >= 0 && j - oC >= 0){
                        chosen = 1 + prev[i - zC][j - oC] ;
                    }
                    int nonChosen = prev[i][j] ;
                    curr[i][j] = Math.max(chosen , nonChosen) ;
                }
            }
            prev = curr ;
        }

        return prev[m][n] ;
    }

    // public int helper(int[][] counts , int i , int m , int n){
    //     if( i >= counts.length) return 0 ;

    //     int zC = counts[i][0] ;
    //     int oC = counts[i][1] ;

    //     int result = 0 ;

    //     if( m - zC >= 0 &&  n - oC >= 0 ){
    //         result = 1 + helper(counts , i + 1 , m - zC , n - oC ) ;
    //     }
    //     int nonChosen = helper(counts , i + 1 , m , n) ;
    //     result = Math.max(result , nonChosen) ;

    //     return result ;
    // }
}