class Solution {
    public int appendCharacters(String s, String t) {
        int result = 0;
        int i = 0 , j = 0 ;
        while(i < s.length() && j < t.length() ){
            if(s.charAt(i) == t.charAt(j)){
                j++ ;
                result++ ;
            }
            i++ ;
        }
        return t.length() - result;
    }
}
