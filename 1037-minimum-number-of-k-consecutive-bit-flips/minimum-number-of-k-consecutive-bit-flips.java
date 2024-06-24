class Solution {
    public int minKBitFlips(int[] nums, int k) {
        int res = 0;
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            while (!q.isEmpty() && i > q.peek() + k - 1) {
                q.remove();
            }

            if ((q.size() + nums[i]) % 2 == 0) {
                if (i + k > nums.length)
                    return -1;

                q.add(i);
                res++;
            }
        }

        return res;
    }///
}