class Solution {
    public List<String> commonChars(String[] words) {
        int[] result = new int[26];
        for (char ch : words[0].toCharArray()) {
            result[ch - 'a']++;
        }
        for (int i = 1; i < words.length; i++) {
            int[] count = new int[26] ;
            for(char ch : words[i].toCharArray()){
                count[ch-'a']++ ;
            } 
            for(int k = 0 ; k < 26 ; k++){
                 result[k] = Math.min(result[k] , count[k] ) ;
            }
        }

        List<String> list = new ArrayList<>() ;
        for(int i = 0 ; i < 26 ; i++){
            int counter = result[i] ;
            while(counter-- > 0){
                list.add(  new String(  (char)( 'a' + i ) +"" ) );
            }
        }
        return list ;
    }
}