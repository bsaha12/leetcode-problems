class Solution {
    public boolean threeConsecutiveOdds(int[] arr) {
        int len = 0;
        for (int num : arr) {
            if (num % 2 != 0) {
                len++;
                if (len == 3)
                    return true;
            } else
                len = 0;
        }
        return false;
    }
}