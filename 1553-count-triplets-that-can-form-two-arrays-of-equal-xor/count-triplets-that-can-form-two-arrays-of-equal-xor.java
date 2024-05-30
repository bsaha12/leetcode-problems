class Solution {
    public int countTriplets(int[] arr) {
        int prefix[] = new int[arr.length + 1] ;
        prefix[0] = 0 ;
        for(int i = 1 ; i < prefix.length ; i++){
            prefix[i] = prefix[i-1] ^ arr[i-1] ;
        }

        int res = 0 ;
        for(int i = 0 ; i < prefix.length - 1  ; i++ ){
            for(int j = i + 1 ; j < prefix.length ; j++){
                if(prefix[i] == prefix[j] ){
                    int len = j - i ;
                    res += len - 1 ;
                }
            }
        }
        return res ;
    }//
}