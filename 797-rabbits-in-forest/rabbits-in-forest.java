class Solution {
    public int numRabbits(int[] answers) {
        int count[] = new int[1001] ;

        int result = 0 ;
        for(int i = 0 ; i < answers.length ; i++){
            int curr = answers[i] ;
            if(count[curr] == curr ){
                result += curr + 1 ;
                count[curr] = 0 ;
            }else{
                count[curr]++ ;
            }
        }

        for(int i = 0 ; i < 1001 ; i++ ){
            result += count[i] == 0 ? 0 : i + 1 ;
        }
        return result ;
    }
}