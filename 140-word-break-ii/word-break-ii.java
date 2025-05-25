class Solution {
    Map<Integer , List<String>> cache ;
    public List<String> wordBreak(String s, List<String> wordDict) {
        cache = new HashMap<>() ;
        List<String> result = helper(s , 0 , wordDict) ;
        return result ;
    }

    public List<String> helper(String s, int fromIndex, List<String> wordDict ){
        if(cache.containsKey(fromIndex)) return cache.get(fromIndex) ;

        List<String> result = new ArrayList<>() ;
        for(int i = fromIndex ; i < s.length() ; i++){
            String prefix = s.substring(fromIndex , i+1) ;
            // prefix "leet"
            if(wordDict.contains(prefix) ) {
                if( i + 1 == s.length()) result.add(prefix) ;
                else{
                    List<String> suffixes = helper( s , i + 1 , wordDict ) ; // "code r" , "coder"
                    for(String suffix : suffixes){
                        result.add(prefix + " " +suffix) ;
                    }
                }
            }
        }

        cache.put(fromIndex , result) ;
        return result ;
    }
}