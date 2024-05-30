class Solution {
    public int countTriplets(int[] arr) {
        int count = 0 ;
        for(int i = 0 ; i < arr.length - 1 ; i++){
            int a = 0 ;
            for(int j = i ; j < arr.length - 1 ; j++ ){
                a = a ^ arr[j] ;
                int b = 0 ;
                for(int k = j + 1 ; k < arr.length ; k++){
                    b = b ^ arr[k] ;
                    if(b == a) count++ ;
                }
            }
        }
        return count ;
    }
}