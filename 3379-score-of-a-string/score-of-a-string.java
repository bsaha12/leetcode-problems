class Solution {
    public int scoreOfString(String s) {
        int result = 0 ;
        for(int i = 1 ; i < s.length() ; i++ ){
            result += Math.abs((int) s.charAt(i) - (int)s.charAt(i - 1)  ) ;
        }
        return result ;
    }
}