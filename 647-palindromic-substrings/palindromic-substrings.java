class Solution {
    public int countSubstrings(String str) {
        char[] s = str.toCharArray();
        int m = s.length;
        boolean[] prev = new boolean[m] ;
        int count = 0;
        for (int i = m - 1; i >= 0; i--) {
            boolean[] curr = new boolean[m];
            curr[i] = true ;
            count++ ;
            for (int j = i + 1; j < m; j++) {
                if(s[i] != s[j]) continue ;
                
                // equal
                if(i + 1 == j) curr[j] = true ;
                else curr[j] = prev[j-1] ;

                if(curr[j]) count++ ;
            }
            // System.out.println(Arrays.toString(curr)) ;
            // System.out.println(count) ;
            prev = curr ;
        }
        return count;
    }

    // public boolean isPalindrome(int i , int j){
    //     if(i == j) return true ;
    //     if(i > j) return true ;

    //     if(cache[i][j] == null){
    //         if(s[i] == s[j]) cache[i][j] = isPalindrome(i + 1 , j - 1) ;
    //         else cache[i][j] = false ;
    //     }

    //     return cache[i][j] ;
    // }
}