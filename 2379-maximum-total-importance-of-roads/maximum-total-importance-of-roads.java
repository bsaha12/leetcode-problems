class Solution {
    public long maximumImportance(int n, int[][] roads) {
        int[] degree = new int[n] ;

        for(int[] road : roads ){
            degree[road[0] ]++ ; 
            degree[road[1] ]++ ; 
        }

        Arrays.sort(degree) ;

        long totalImportance = 0 ;
        int currValue = 1 ;

        for(int d : degree){
            totalImportance += (long)currValue * d ;
            currValue++ ;
        }
        return totalImportance ;
    }/////
}