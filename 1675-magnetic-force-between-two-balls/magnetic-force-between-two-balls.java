class Solution {
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position) ;
        int low = 1 ;
        int high = position[position.length -1] - position[0] ;
        int result = 1 ;
        while(low <= high){
            int mid = low + (high - low)/ 2 ;
            if(isPossible(mid , position , m) ){
                result = mid ;
                low = mid + 1 ;
            }else{
                high = mid - 1 ;
            }
        }
        return result ;
    }///
    boolean isPossible(int min , int[] position , int m ){
        int count = 1 ;
        int prev = position[0] ;
        for(int pos : position){
            if(pos - prev >= min){
                count++ ;
                prev = pos ;
            }
        }
        return count >= m ;
    }///
}