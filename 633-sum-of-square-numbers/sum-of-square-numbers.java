class Solution {
    public boolean judgeSquareSum(int c) {
        int n = (int) Math.sqrt(c) ;

        int i = 0 ;
        int j = n ;
        while(i <= j){
            long i1 = i ;
            long j1 = j ;
            long num =  i1*i1 + j1*j1 ;
            if(num > c) j-- ;
            else if(num < c) i++ ;
            else return true ;
        }       
        return false ;
    }
}