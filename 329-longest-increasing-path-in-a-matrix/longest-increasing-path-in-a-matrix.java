class Solution {
    int[][] cache, matrix;

    public int longestIncreasingPath(int[][] mat) {
        matrix = mat;
        cache = new int[matrix.length][matrix[0].length];
        for (int[] arr : cache) {
            Arrays.fill(arr, -1);
        }

        int result = 1;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                result = Math.max(helper(i, j), result);
            }
        }

        return result;
    }

    int helper(int i, int j) {
        if (i < 0 || j < 0 || i >= matrix.length || j > matrix[0].length) {
            return 0;
        }

        if (cache[i][j] != -1)
            return cache[i][j];

        int curr = matrix[i][j];
        int pathValues = 0;

        int top = i - 1 >= 0 ? matrix[i - 1][j] : -1;
        int bottom = i + 1 < matrix.length ? matrix[i + 1][j] : -1;
        int left = j - 1 >= 0 ? matrix[i][j - 1] : -1;
        int right = j + 1 < matrix[0].length ? matrix[i][j + 1] : -1;

        if (top > curr)
            pathValues = Math.max(pathValues, helper(i - 1, j));
        if (bottom > curr)
            pathValues = Math.max(pathValues, helper(i + 1, j));
        if (left > curr)
            pathValues = Math.max(pathValues, helper(i, j - 1));
        if (right > curr)
            pathValues = Math.max(pathValues, helper(i, j + 1));

        return cache[i][j] = 1 + pathValues;
    }
}