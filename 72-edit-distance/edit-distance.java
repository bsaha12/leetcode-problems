class Solution {
    char[] wordA , wordB;
    int[][] dp ;
    public int minDistance(String word1, String word2) {
        wordA = word1.toCharArray();
        wordB = word2.toCharArray();
        dp = new int[wordA.length + 1][wordB.length + 1] ;
        for(int[] row : dp ){
            Arrays.fill(row , -1) ;
        }
        return helper(0, 0);
    }

    public int helper(int i, int j) {
        // base conditions
        if(dp[i][j] != -1){
            return dp[i][j] ;
        }
        if (j == wordB.length)
            return wordA.length - i;
        if (i == wordA.length)
            return wordB.length - j;


        int result = 0;
        if (wordA[i] == wordB[j]) {
            result = helper(i + 1, j + 1);
        } else {
            int replace = helper(i + 1, j + 1);
            int delete = helper(i + 1, j);
            int insert = helper(i, j + 1);

            result = Math.min(Math.min(replace, delete), insert) + 1;
        }

        dp[i][j] = result ;

        return result;

    }
}