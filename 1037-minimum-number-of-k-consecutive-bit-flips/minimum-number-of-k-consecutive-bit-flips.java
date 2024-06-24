class Solution {
    public int minKBitFlips(int[] nums, int k) {
        int res = 0;
        int currentFlips = 0 ;
        // Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            //flip validity w.r.t. window
            // while (!q.isEmpty() && i > q.peek() + k - 1) {
            //     q.remove();
            // }/
            if(i - k >= 0 && nums[i - k] == 2 ){
                currentFlips-- ;
            }


            // if ((q.size() + nums[i]) % 2 == 0) {
            //     if (i + k > nums.length)
            //         return -1;

            //     q.add(i);
            //     res++;
            // }

            if((currentFlips + nums[i] ) % 2 == 0){
                if(i + k > nums.length) return - 1 ;

                currentFlips++ ;
                res++ ;
                nums[i] = 2 ;
            }
        }

        return res;
    }///
}