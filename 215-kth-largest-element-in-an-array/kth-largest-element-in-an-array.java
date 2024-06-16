class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((x , y) -> y - x) ;
        for(int num : nums){
            maxHeap.offer(num) ;
        }

        while(k-- > 1 ){
            maxHeap.poll() ;
        }

        return maxHeap.poll() ;

    }
}