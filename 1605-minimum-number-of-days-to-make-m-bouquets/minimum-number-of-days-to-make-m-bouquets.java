class Solution {
    int[] arr ; 
    public int minDays(int[] bloomDay, int m, int k) {
        int max = 0 ;
        for(int temp : bloomDay){
            max = Math.max(max , temp) ;
        }
        arr = bloomDay ;
        int result = -1 ;
        int low = 0 ;
        int high = max ;
        while(low <= high){
            int mid = low + (high - low) / 2 ;
            if(isPossible(mid , m , k) ){
                result = mid ;
                high = mid - 1 ;
            }else{
                low = mid +1 ;
            }
        }

        return result ;
    }//////

    boolean isPossible(int days , int m , int k){
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