class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] arr = new int[1001] ;
        for(int num : arr1){
            arr[num]++ ;
        }
        int pos = 0 ;
        for(int i = 0 ; i < arr2.length ; i++){
            int curr = arr2[i] ;
            int freq = arr[curr] ;
            arr[curr] = 0 ;
            while(freq-- > 0){
                arr1[pos] = curr ;
                pos++ ;
            }
        }

        for(int i = 0 ; i <= 1000 ; i++ ){
            int freq = arr[i] ;
            while(freq-- > 0){
                arr1[pos] = i ;
                pos++ ;
            }
        }
        return arr1 ;
    }
}