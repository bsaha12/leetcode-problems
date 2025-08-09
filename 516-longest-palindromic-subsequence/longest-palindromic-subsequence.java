class Solution {
    char[] s;
    int[][] cache;

    public int longestPalindromeSubseq(String str) {
        s = str.toCharArray();
        int n = s.length;
        cache = new int[n][n];
        for (int[] arr : cache) {
            Arrays.fill(arr, -1);
        }
        return helper(0, n - 1);
    }

    public int helper(int i, int j) {
        if (i == j)
            return 1;
        if (i > j)
            return 0;

        // cache
        int result = cache[i][j];
        if (result == -1) {
            if (s[i] == s[j])
                result = 2 + helper(i + 1, j - 1);
            else
                result = Math.max(helper(i + 1, j), helper(i, j - 1));
        }

        return cache[i][j] = result;

    }
}