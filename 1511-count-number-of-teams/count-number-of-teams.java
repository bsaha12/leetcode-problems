class Solution {
    public int numTeams(int[] rating) {
        int count = 0 ;
        int n = rating.length ;
        for(int i = 0 ; i < n ; i++){
            int first = rating[i] ;
            for(int j = i + 1 ; j < n ; j++){
                int second = rating[j] ;
                for(int k = j + 1 ; k < n ; k++){
                    int third = rating[k] ;
                    if(first < second && second < third){
                        count++ ;
                    }else if(first > second && second > third){
                        count++ ;
                    }
                }
            }
        }

        return count ;
    }
}