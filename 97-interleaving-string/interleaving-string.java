class Solution {
    char[] str1 , str2 , str3 ;
    int[][] dp ;
    public boolean isInterleave(String s1, String s2, String s3) {
       int l1 = s1.length() ;
       int l2 = s2.length() ;
       int l3 = s3.length() ;
       if(l1 + l2 != l3) return false ;
       str1 = s1.toCharArray() ;
       str2 = s2.toCharArray() ;
       str3 = s3.toCharArray() ;
       dp = new int[ l1 + 1 ][ l2+ 2] ;
       for(int[] arr : dp){
        Arrays.fill(arr , -1) ;
       }
       return helper( 0 , 0)  ;
    }

    public boolean helper(int i , int j){
        int k = i + j ;
        if(k == str3.length) {
            return i == str1.length && j == str2.length ;
        }

        if(dp[i][j] != -1){
            return dp[i][j] == 1 ? true : false ;
        }

        boolean first = false , second = false ; 
        if( i < str1.length && k < str3.length && str1[i] == str3[k] ){
            first = helper(i + 1 , j) ;
        }

        if(!first && j < str2.length && k < str3.length && str2[j] == str3[k] ){
            second = helper(i , j + 1) ;
        }

        dp[i][j] = first || second ? 1 : 0 ;

        return first || second;

    }
}