class Solution {
    char[] s ;
    Boolean[][] cache ;
    public int countSubstrings(String str) {
        s = str.toCharArray() ;
        int m = s.length ;
        cache = new Boolean[m][m] ;
        int count = 0 ;
        for(int i = 0 ; i < m ; i++){
            for(int j = i ; j < m ; j++){
                if(isPalindrome(i , j)){
                    count++ ;
                }
            }
        }
        return count ;
    }

    public boolean isPalindrome(int i , int j){
        if(i == j) return true ;
        if(i > j) return true ;

        if(cache[i][j] == null){
            if(s[i] == s[j]) cache[i][j] = isPalindrome(i + 1 , j - 1) ;
            else cache[i][j] = false ;
        }

        return cache[i][j] ;
    }
}