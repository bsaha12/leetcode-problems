class Solution {
    public String reverseParentheses(String s) {
        char[] arr = s.toCharArray() ;
        Stack<Integer> st = new Stack<>() ;
        int n = arr.length ;
        /// first pass 
        int[] marker = new int[n] ;
        for(int i = 0 ; i < n ; i++){
            char ch = arr[i] ;
            if(ch == '(' ){
                st.push(i) ;
            }else if(ch == ')'){
                int k = st.pop() ;
                marker[i] = k ;
                marker[k] = i ;
            }
        }

        //2nd pass
        int i = 0 ;
        StringBuilder result = new StringBuilder() ;
        int dir = 1 ;
        while(i < n){
            if(arr[i] == ')' || arr[i] == '(' ){
                i = marker[i] ;
                dir *= -1 ;
            }else{
                result.append(arr[i] );
            }
            i += dir ;
        }
        return result.toString() ;
    }/////
}