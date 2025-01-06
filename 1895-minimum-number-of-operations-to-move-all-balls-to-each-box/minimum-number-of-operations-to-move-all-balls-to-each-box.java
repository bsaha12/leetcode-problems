class Solution {
    public int[] minOperations(String boxes) {
        char[] arr = boxes.toCharArray() ;
        int len = arr.length ;
        int[] moves = new int[len] ;
        for(int i = 0 ; i < len ; i++){
            int count = 0 ;
            for(int j = 0 ; j < len ; j++){
                if(i != j){
                    if(arr[j] == '1'){
                        count += Math.abs(i - j) ;
                    }
                }
            }
            moves[i] = count ;
        }

        return moves ;
    }
}