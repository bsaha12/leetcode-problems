class Solution {
    public int findTheWinner(int n, int k) {
        int[] arr = new int[n];
        // for (int i = 0; i < n; i++) {
        //     arr[i] = i + 1;
        // }
        int count = n;
        int start = 0;
        while (count > 1) {
            // System.out.println("----start---");
            // System.out.println("start : " + start);
            int steps = k ;
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
            // System.out.println("Curr : " + curr) ;
            while (arr[curr] == -1) {
                if (curr == n - 1) {
                    curr = 0;
                } else {
                    curr++;
                }
            }
            start = curr;
            // System.out.println("Next Start : " + start) ;
            // System.out.println("----end---");
        }
        return start + 1;
    }
}