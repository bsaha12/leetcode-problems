class Solution {
    public int longestSubarray(int[] nums, int limit) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((x, y) -> y[0] - x[0]);
        // PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((x, y) -> x[0] - y[0]);
        int left = 0, maxLength = 1;
        for (int i = 0; i < nums.length; i++) {
            maxHeap.offer(new int[] { nums[i], i });
            minHeap.offer(new int[] { nums[i], i });

            // do certain process to make it a valid window
            while (maxHeap.peek()[0] - minHeap.peek()[0] > limit) {

                left = Math.min(maxHeap.peek()[1], minHeap.peek()[1]) + 1;

                while(maxHeap.peek()[1] < left ){
                    maxHeap.poll() ;
                }
                while(minHeap.peek()[1] < left ){
                    minHeap.poll() ;
                }

            }

            maxLength = Math.max(maxLength, i - left + 1);
        }
        return maxLength;
    }/////
}