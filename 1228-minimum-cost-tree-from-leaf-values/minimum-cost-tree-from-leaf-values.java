class Solution {
    int[] a;
    int[][] cache;

    public int mctFromLeafValues(int[] arr) {
        a = arr;
        int n = a.length;
        cache = new int[n][n];
        for (int[] temp : cache) {
            Arrays.fill(temp, -1);
        }
        return helper(0, a.length - 1);
    }

    public int helper(int start, int end) {
        if (start == end)
            return 0;
        if (cache[start][end] == -1) {
            int n = end - start + 1;
            int[] leftMaxArr = new int[a.length];
            int[] rightMaxArr = new int[a.length];
            int currMax = a[start];
            for (int i = start; i <= end; i++) {
                currMax = Math.max(a[i], currMax);
                leftMaxArr[i] = currMax;
            }

            currMax = a[end];
            for (int i = end; i >= start; i--) {
                currMax = Math.max(a[i], currMax);
                rightMaxArr[i] = currMax;
            }
            int result = Integer.MAX_VALUE;
            for (int k = start; k < end; k++) {
                int leftMax = leftMaxArr[k];
                int rightMax = rightMaxArr[k + 1];
                int leftTreeSum = helper(start, k);
                int rightTreeSum = helper(k + 1, end);
                int currSum = (leftMax * rightMax) + leftTreeSum + rightTreeSum;
                result = Math.min(currSum, result);
            }
            cache[start][end] = result;
        }

        return cache[start][end];
    }
}