class Solution {
    // int[] arr ;
    public int numTeams(int[] rating) {
        // arr = rating ;
        int count = 0 ;
        int n = rating.length ;

        int[] rightLesser = new int[n] ;
        int[] rightGreater = new int[n] ;

        int[] leftLesser = new int[n] ;
        int[] leftGreater = new int[n] ;
        for(int i = 0 ; i < n ; i++){
            int curr = rating[i] ;

            int leftSmall = 0 ;
            int leftLarge = 0 ;
            for(int j = 0 ; j < i ; j++){
                if(rating[j] < curr) leftSmall++ ;
                else leftLarge++ ;
            }
            leftLesser[i] = leftSmall ;
            leftGreater[i] = leftLarge ;

            int rightSmall = 0 ;
            int rightLarge = 0 ;
            for(int j = i + 1 ; j < n ; j++){
                if(rating[j] > curr) rightLarge++ ;
                else rightSmall++ ;
            }

            rightLesser[i] = rightSmall ;
            rightGreater[i] = rightLarge ;

        }
        for(int i = 1 ; i < n - 1 ; i++){
            int mid = rating[i] ;

            int rG = rightGreater[i] ;
            int lL = leftLesser[i] ;

            int rL = rightLesser[i] ;
            int lG = leftGreater[i] ;

            count += (rG * lL) + (rL * lG) ;
        }

        return count ;
    }
}