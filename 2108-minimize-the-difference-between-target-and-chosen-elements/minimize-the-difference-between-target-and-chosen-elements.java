class Solution {
    int[][] matrix , cache;
    public int minimizeTheDifference(int[][] mat, int target) {
        matrix = mat ;
        int sum = 0 ;
        for(int[] arr : mat){
            sum += Arrays.stream(arr).max().getAsInt();
        }
        cache = new int[mat.length + 1][sum  + 1] ;
        for(int[] arr : cache ){
            Arrays.fill(arr , -1) ;
        }
        return helper( 0 , 0 , target) ;
    }

    int helper(int i , int sum , int target){
        if(i == matrix.length) return Math.abs(target - sum) ;
        if(cache[i][sum] != -1) return cache[i][sum] ;

        int result = Integer.MAX_VALUE ;
        for(int k = 0 ; k < matrix[i].length ; k++){
            result = Math.min(result , helper( i + 1 , sum + matrix[i][k] , target)) ;
        }

        return cache[i][sum] = result ;
    }
}