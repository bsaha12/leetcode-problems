class Solution {
    int k;
    int[] arr, cache;

    public int maxSumAfterPartitioning(int[] arr, int k) {
        this.arr = arr;
        this.k = k;
        cache = new int[arr.length];
        Arrays.fill(cache, -1);
        return helper(0);
    }

    // represent max sum generated when start at i
    public int helper(int start) { // 0
        if (start >= arr.length)
            return 0;

        if (cache[start] == -1) {
            int maxSum = 0;
            int maxVal = 0;
            int elems = 0;
            for (int i = start; i < arr.length && i < start + k; i++) { // 0 , 1 , 2
                maxVal = Math.max(maxVal, arr[i]);
                elems++;
                int currSum = elems * maxVal;
                int nextSum = helper(i + 1);

                maxSum = Math.max(maxSum, currSum + nextSum);
            }

            cache[start] = maxSum;
        }

        return cache[start];
    }
}