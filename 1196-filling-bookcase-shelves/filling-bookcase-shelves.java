class Solution {
    public int minHeightShelves(int[][] books, int shelfWidth) {
        int n = books.length ;
        int[] dp = new int[n + 1];
        for(int i = n - 1 ; i >= 0 ; i--){
            int currWidth = shelfWidth ;
            int maxHeight = 0 ;
            int result = Integer.MAX_VALUE ;
            for(int j = i ; j < n ; j++){
                int wd = books[j][0] ;
                int ht = books[j][1];

                currWidth -= wd ;
                if(currWidth < 0) break ;

                maxHeight = Math.max(ht , maxHeight) ;
                int totalShelfHeight = maxHeight + dp[ j + 1] ;
                result = Math.min(result , totalShelfHeight) ;
            }
            dp[i] = result ;
        }
        return dp[0] ;
    }


    // draft state
    // public helper(int start){
    //     if(i >= n) return 0 ;

    //     int currWidth = shelfWidth ;
    //     int maxHeight = 0 ;
    //     int result = Integer.MAX_VALUE ;
    //     for(int i = start ; i < n ; i++ ){
    //         int wd = books[i][0] ;
    //         int ht = books[i][1] ;

    //         currWidth -= wd ;
    //         if(currWidth < 0) break ;

    //         maxHeight = Math.max(ht , maxHeight) ;
    //         int toalShelfHeight = maxHeight + helper( i + 1 ) ;

    //         result = Math.min(result , totalShelfHeight) ;
    //     }

    //     return result ;
    // }
}