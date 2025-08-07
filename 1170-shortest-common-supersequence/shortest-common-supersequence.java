class Solution {
    String[][] cache;
    char[] s1, s2;
    String[] p1, p2;
    String st1, st2;

    public String shortestCommonSupersequence(String str1, String str2) {
        s1 = str1.toCharArray();
        s2 = str2.toCharArray();

        int m = s1.length;
        int n = s2.length;

        // p1 = new String[m + 1] ;
        StringBuilder[] prev = new StringBuilder[n + 1];

        // p1[m] = "" ;
        // for(int i = m - 1 ; i >= 0  ; i--){
        //     p1[i] = str1.substring(i) ; //s1[i] + p1[i + 1] ; // 
        // }

        prev[n] = new StringBuilder();
        for (int j = n - 1; j >= 0; j--) {
            prev[j] = new StringBuilder(prev[j + 1].toString()); // s2[j] + p2[j + 1] ; 
            prev[j].insert(0, s2[j]);

            // System.out.println(prev[j].toString());
        }

        for (int i = m - 1; i >= 0; --i) {
            StringBuilder[] curr = new StringBuilder[n + 1];
            curr[n] = new StringBuilder(prev[n].toString());
            curr[n].insert(0, s1[i]);
            // System.out.println("-------------------") ;
            // System.out.println(prev[n].toString()) ;
            // System.out.println(curr[n].toString()) ;
            // System.out.println("--------------------") ;
            for (int j = n - 1; j >= 0; j--) {
                char ch1 = s1[i];
                char ch2 = s2[j];

                if (ch1 == ch2) {
                    curr[j] = prev[j + 1].insert(0 , ch1);
                } else {
                    StringBuilder topFix = new StringBuilder(curr[j + 1].toString()).insert(0 , ch2);
                    StringBuilder bottomFix = new StringBuilder(prev[j].toString()).insert(0 , ch1);
                    if (topFix.length() > bottomFix.length())
                        curr[j] = bottomFix;
                    else
                        curr[j] = topFix;
                }
            }
            prev = curr;
        }

        return prev[0].toString();

        // st1 = str1 ; 
        // st2 = str2 ;

        // cache = new String[m][n];
        // return helper(0, 0);
    }

    // public String helper(int i, int j) {
    //     if (i == s1.length && j == s2.length)
    //         return "";
    //     if (i == s1.length){
    //         return p2[j] ;
    //         // return st2.substring(j) ;
    //     }
    //     if(j == s2.length){
    //         return p1[i] ;
    //         // return st1.substring(i);
    //     }

    //     if (cache[i][j] == null) {
    //         char ch1 = s1[i];
    //         char ch2 = s2[j];

    //         if (ch1 == ch2) {
    //             cache[i][j] = ch1 + helper(i + 1 , j + 1) ;
    //         }else{
    //             String topFix = ch2 + helper(i , j + 1) ;
    //             String bottomFix = ch1 + helper( i + 1 , j) ;
    //             if(topFix.length() > bottomFix.length()) cache[i][j] = bottomFix ;
    //             else cache[i][j] = topFix ;
    //         }
    //     }

    //     return cache[i][j] ;
    // }
}