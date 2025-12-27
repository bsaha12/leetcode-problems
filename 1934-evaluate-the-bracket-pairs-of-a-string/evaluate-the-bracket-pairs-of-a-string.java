class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        // pre-process the knowledge to optimize the lookup
        Map<String,String> map = new HashMap<>() ;
        for(List<String> list : knowledge){
            map.put(list.get(0) , list.get(1)) ;
        }

        int i = 0 ;
        StringBuilder result = new StringBuilder() ;
        int len = s.length() ;
        while(i < len){
            char currChar = s.charAt(i) ;
            if(currChar == '('){
                // find next char ;
                int j = i + 1;
                StringBuilder placeholder = new StringBuilder() ;
                while(j < len){
                    if(s.charAt(j) == ')'){
                        i = j + 1 ;
                        break ; 
                    }
                    placeholder.append(s.charAt(j)) ;
                    j++ ;
                }

                String value = map.get(placeholder.toString()) ;
                if(value == null){
                    result.append('?');
                }else{
                    result.append(value) ;
                }

            }else{
                result.append(currChar) ;
                i++ ;
            }
        }

        return result.toString() ;
    }
}