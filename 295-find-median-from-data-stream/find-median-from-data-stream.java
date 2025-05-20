class MedianFinder {
    PriorityQueue<Integer> leftMaxHeap , rightMinHeap ;

    public MedianFinder() {
        leftMaxHeap = new PriorityQueue<Integer>((a , b) -> Integer.compare(b , a)) ;
        rightMinHeap = new PriorityQueue<Integer>((a , b) -> Integer.compare(a , b)) ;
    }
    
    public void addNum(int num) {
        leftMaxHeap.offer(num) ;
        rightMinHeap.offer(leftMaxHeap.poll()) ;
        if(rightMinHeap.size() > leftMaxHeap.size() ){
            leftMaxHeap.offer(rightMinHeap.poll()) ;
        }
    }
    
    public double findMedian() {
        if(leftMaxHeap.size() == rightMinHeap.size()){
            return (double) (leftMaxHeap.peek() + rightMinHeap.peek() ) / 2 ;
        }

        return leftMaxHeap.peek() ;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */