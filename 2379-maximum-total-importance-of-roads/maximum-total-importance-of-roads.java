class Solution {
    public long maximumImportance(int n, int[][] roads) {
        int[][] degree = new int[n][2] ;
        for(int i = 0 ; i < n ; i++){
            degree[i][0] = i ;
        }

        for(int[] road : roads ){
            int city1 = road[0] ;
            int city2 =  road[1] ;
            degree[city1][1]++ ;
            degree[city2][1]++ ;
        }

        Arrays.sort(degree , (int[] arr1 , int[] arr2 ) -> Integer.compare(arr2[1] , arr1[1] ) ) ;
        int[] values = new int[n] ;
        int curr = n ;
        for(int i = 0 ; i < n ; i++){
            values[degree[i][0] ] = curr ;
            curr-- ;
        }

        long result = 0 ;
        for(int[] road : roads ){
            int city1 = road[0] ;
            int city2 =  road[1] ;
            result += (values[city1] + values[city2] ) ;
        }
        return result ;
    }
}