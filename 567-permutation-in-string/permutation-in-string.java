class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] str1 = new int[26] ;
        int[] window = new int[26] ;
        for(int i = 0 ; i < s1.length() ; i++){
            char ch = s1.charAt(i) ;
            str1[ch - 'a']++ ;
        }

        if(s1.length() > s2.length()) return false ;

        int i = 0 ;
        for(int j = 0 ; j < s2.length() ; j++){
            char curr = s2.charAt(j) ;
            if(j - i + 1 < s1.length()){
                window[curr - 'a']++ ;
            }else{
                window[curr - 'a']++ ;
                if(matches(window , str1)) return true ;
                window[s2.charAt(i) - 'a']-- ;
                i++ ;
            }
        }

        return false ;
    }

    public boolean matches(int[] window , int[] str1 ){
        for(int i = 0 ; i < 26 ; i++){
            if(window[i] != str1[i]) return false ;
        }

        return true ;
    }
}