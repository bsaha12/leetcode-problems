class Solution {
    public int candy(int[] ratings) {
      int n = ratings.length ;
      int count = n , i = 1 ;
      while(i < n){
        if(ratings[i] == ratings[i - 1] ){
            i++ ;
             continue ;
        }

        int peak = 0 ;
        while(i < n && ratings[i] > ratings[i - 1] ){
            peak++ ;
            i++ ;
            count += peak ;
        }

        int valley = 0;
        while(i < n && ratings[i] < ratings[ i - 1] ){
            valley++ ;
            i++ ;
            count += valley ;
        }

        count -= Math.min(peak , valley) ;
      }  
      return count ;
    }
}