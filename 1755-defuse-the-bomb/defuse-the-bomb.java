class Solution {
    public int[] decrypt(int[] code, int k) {
        int len = code.length;
        int[] result = new int[len];
        for (int i = 0; i < len; i++) {
            result[i] = findSumWithStartingPoint(code, k, i );
        }
        return result;
    }/////

    int findSumWithStartingPoint(int[] code, int k, int start) {
        boolean isForward = k >= 0;
        k = Math.abs(k);
        int len = code.length;
        int sum = 0;
        while (k > 0) {
            // increment or decrement
            if (isForward) {
                start++;
            } else {
                start--;
            }

            // resetting due to circular nature
            if (start == len) {
                start = 0;
            }
            if (start == -1) {
                start = len - 1;
            }

            // sum
            sum += code[start];
            k--;
        }

        return sum;
    }////
}