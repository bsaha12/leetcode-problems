class Solution {
    public int findTheWinner(int n, int k) {
        int[] arr = new int[n];
        int count = n;
        int start = 0;
        while (count > 1) {
            int steps = k % count == 0 ? count : k % count;
            int curr = start;
            while (steps > 0) {
                if (arr[curr] != -1) {
                    steps--;
                }
                if (steps == 0) {
                    break;
                }
                if (curr == n - 1) {
                    curr = 0;
                } else {
                    curr++;
                }
            }

            arr[curr] = -1;
            count--;
            while (arr[curr] == -1) {
                if (curr == n - 1) {
                    curr = 0;
                } else {
                    curr++;
                }
            }
            start = curr;
        }
        return start + 1;
    }
}