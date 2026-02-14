class Solution {
    public int firstUniqChar(String s) {
        int[] count = new int[26] ;

        for(char ch : s.toCharArray()){
            count[ch - 'a']++ ;
        }

        for(int i = 0 ; i < s.length() ; i++){
            if(count[s.charAt(i) - 'a'] == 1) return i ;
        }

        return -1;
    }
}