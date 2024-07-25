class Solution {
    public int[] sortArray(int[] nums) {
        PriorityQueue<Integer> heap = new PriorityQueue<>() ;
        for(int num : nums){
            heap.offer(num) ;
        }
        int i = 0 ;
        while(!heap.isEmpty() ){
            nums[i] = heap.poll() ;
            i++ ;
        }
        return nums ;
    }
}