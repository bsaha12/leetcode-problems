class Solution {
    int[][] cache ;
    char[] s1 , s2 ;
    int[] p1 , p2 ;
    public int minimumDeleteSum(String st1, String st2) {
        s1 = st1.toCharArray() ;
        s2 = st2.toCharArray() ;

        int m = s1.length ;
        int n = s2.length ;

        p1 = new int[m + 1] ;
        p2 = new int[n + 1] ;
        cache = new int[m][n] ;

        // fill up the prefixes
        for(int i = m - 1 ; i >= 0 ; i--){
            p1[i] = p1[i + 1] + (int)s1[i]  ;
        }

        for(int i = n - 1 ; i >= 0 ;i--){
            p2[i] = p2[i+1] + (int) s2[i] ;
        }
        for(int[] arr : cache){
            Arrays.fill(arr , -1) ;
        }

        return helper(0 , 0) ;
    }

    public int helper(int i , int j){
        // base case
        if(i == s1.length) return p2[j];
        if( j == s2.length) return p1[i] ;

        if(cache[i][j] == -1){
            if(s1[i] == s2[j]) cache[i][j] = helper( i + 1 , j + 1);
            else{
                int top = (int)s2[j] + helper( i , j + 1) ;
                int bottom = (int)s1[i] + helper(i + 1 , j);
                cache[i][j] = Math.min(top , bottom) ;
            }
        }

        return cache[i][j] ;
    }
}