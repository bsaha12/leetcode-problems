class Solution {
    public int minDifference(int[] nums) {
        if(nums.length <= 4) return 0 ;
        //Keep smallest 4 numbers
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((x , y) -> y - x) ;
        for(Integer num : nums){
            maxHeap.offer(num) ;
            if(maxHeap.size() > 4 ){
                maxHeap.poll() ;
            }
        }
        List<Integer> small = new ArrayList<>(maxHeap) ;
        Collections.sort(small) ;

        //Keep largest 4 numbers
        PriorityQueue<Integer> minHeap = new PriorityQueue<>() ;
        for(Integer num : nums){
            minHeap.offer(num) ;
            if(minHeap.size() > 4 ){
                minHeap.poll() ;
            }
        }
        List<Integer> large = new ArrayList<>(minHeap) ;
        Collections.sort(large) ;

        int min = Integer.MAX_VALUE ;
        for(int i = 0 ; i < 4 ; i++){
            min = Math.min(min , large.get(i) - small.get(i) ) ;
        }
        return min ;

    }
}