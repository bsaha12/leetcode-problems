class Solution {
    // int[][] cache ;
    // char[] s1 , s2 ;
    // int[] p1 , p2 ;
    public int minimumDeleteSum(String st1, String st2) {
        char[] s1 = st1.toCharArray() ;
        char[] s2 = st2.toCharArray() ;

        int m = s1.length ;
        int n = s2.length ;

        // p1 = new int[m + 1] ;
        int[] prev = new int[n + 1] ;
        // cache = new int[m][n] ;

        // fill up the prefixes
        // for(int i = m - 1 ; i >= 0 ; i--){
        //     p1[i] = p1[i + 1] + (int)s1[i]  ;
        // }

        for(int j = n - 1 ; j >= 0 ; j--){ // actually j 
            prev[j] = prev[j+1] + (int) s2[j] ;
        }
        // for(int[] arr : cache){
        //     Arrays.fill(arr , -1) ;
        // }

        // return helper(0 , 0) ;

        for(int i = m - 1 ; i >= 0 ; i--){
            int[] curr = new int[n + 1] ;
            curr[n] = prev[n] + (int) s1[i] ;
            for(int j = n - 1 ; j >= 0 ; j--){
                if( s1[i] == s2[j]) curr[j] = prev[j + 1] ;
                else{
                    int top = (int) s2[j] + curr[j+1] ;
                    int bottom = (int) s1[i] + prev[j] ;
                    curr[j] = Math.min(top , bottom) ;
                }
            }
            prev = curr ;
        }

        return prev[0] ;
    }

    // public int helper(int i , int j){
    //     // base case
    //     if(i == s1.length) return p2[j];
    //     if( j == s2.length) return p1[i] ;

    //     if(cache[i][j] == -1){
    //         if(s1[i] == s2[j]) cache[i][j] = helper( i + 1 , j + 1);
    //         else{
    //             int top = (int)s2[j] + helper( i , j + 1) ;
    //             int bottom = (int)s1[i] + helper(i + 1 , j);
    //             cache[i][j] = Math.min(top , bottom) ;
    //         }
    //     }

    //     return cache[i][j] ;
    // }
}