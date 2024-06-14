class Solution {
    public int candy(int[] ratings) {
        int[] marker = new int[ratings.length] ;
        marker[0] = 1 ;
        for(int i = 1 ; i < ratings.length ; i++  ){
            if(ratings[i] > ratings[i-1] ){
                marker[i] = marker[i - 1] + 1 ;
            }else{
                marker[i] = 1 ;
            }
        }

        for(int i = ratings.length - 2 ; i >= 0 ; i--){
            if(ratings[i] > ratings[i + 1] ){
                marker[i] = Math.max(marker[i + 1] + 1 , marker[i] ) ;
            }
        }

        int sum = 0 ;
        for(int num : marker){
            sum += num ;
        }
        return sum ;
    }
}