class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int result = 0;
        int n = customers.length;
        for(int i = 0 ; i < n ; i++){
            if(grumpy[i] == 0 ){
                result += customers[i] ;
            }
        }
        int i = 0 ;
        int j = 0 ;
        int sum = result ;
        while(j < n){
            if(j - i + 1 < minutes){
                if(grumpy[j] == 1 ){
                    sum += customers[j]  ;
                }
                j++ ;
            }else{
                if(grumpy[j] == 1 ){
                    sum += customers[j]  ;
                }
                result = Math.max(result , sum) ;
                j++ ;
                if(grumpy[i] == 1 ){
                    sum -= customers[i]  ;
                }
                i++ ;
            }
        }
        return result ;
    }
}