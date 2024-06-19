class Solution {
    int[] arr ; 
    public int minDays(int[] bloomDay, int m, int k) {
        long max = 0 ;
        for(int temp : bloomDay){
            max = max + temp ;
        }
        arr = bloomDay ;
        long result = -1 ;
        long low = 0 ;
        long high = max ;
        while(low <= high){
            long mid = low + (high - low) / 2 ;
            if(isPossible(mid , m , k) ){
                result = mid ;
                high = mid - 1 ;
            }else{
                low = mid +1 ;
            }
        }

        return (int)result ;
    }//////

    boolean isPossible(long days , int m , int k){
        int bouqueCount = 0 ;
        int i = 0 ;
        while(i < arr.length){
            if(arr[i] > days ){
                i++ ;
                continue ;
            }
            int count = k ;
            while( i < arr.length && arr[i] <= days &&  count > 0){
                i++ ;
                count-- ;
            }
            if(count == 0){
                bouqueCount++ ;
            }
        }
        return bouqueCount >= m ;

    }///
}