class Solution {
    public int isPrefixOfWord(String sentence, String searchWord) {
        String[] arr = sentence.split(" ") ;
        for(int i = 0 ; i < arr.length ; i++){
            String word = arr[i] ;
            if(word.indexOf(searchWord) == 0) {
                return i + 1 ;
            }
        }

        return -1 ;
    }
}