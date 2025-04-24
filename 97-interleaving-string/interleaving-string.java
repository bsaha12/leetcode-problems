class Solution {
    char[] str1 , str2 , str3 ;
    int[][][] dp ;
    public boolean isInterleave(String s1, String s2, String s3) {
        str1 = s1.toCharArray() ;
        str2 = s2.toCharArray() ;
        str3 = s3.toCharArray() ;

        if(str1.length + str2.length != str3.length) return false ;

        String s4 = s1 + s2 ;
        String s5 = s1 + s2 ;
        if(s3.equals(s4) || s3.equals(s5)) return true ;

        dp = new int[str1.length + 1][str2.length + 1][str3.length + 1] ;

        return helper(0 , 0 , 0) ;
    }

    public boolean helper(int i , int j , int k){
        if(i >= str1.length && j >= str2.length){
            if(k == str3.length) return true ;
            else return false ;
        }

        if( k >= str3.length) return false ;


        if(dp[i][j][k] != 0) return dp[i][j][k] == 1 ? true : false ;

        char ch1 = i == str1.length ? '!' : str1[i] ;
        char ch2 = j == str2.length ? '!' : str2[j] ;
        char ch3 = str3[k] ;

       boolean result = false ;
       if(ch1 != ch3 && ch2 != ch3) result =  false ;
       else if(ch1 == ch3 && ch2 == ch3) result = helper(i+1,j,k+1)||helper(i,j+1,k+1);
       else if(ch1 == ch3) result = helper(i+1,j,k+1) ;
       else result = helper(i,j+1,k+1) ;

       dp[i][j][k] = result ? 1 : -1 ;

       return result ;

    }
}