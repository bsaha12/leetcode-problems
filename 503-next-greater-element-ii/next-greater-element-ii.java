class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> st = new Stack<>() ;

        // pre-process the intial stack
        for(int i = nums.length - 2 ; i >= 0 ; i-- ){
            int num = nums[i] ;

            while(!st.isEmpty() && nums[st.peek()] <= num ){
                st.pop() ;
            }

            st.push(i) ;
        }

        int[] result = new int[nums.length] ;
        for(int i = nums.length - 1 ; i >= 0 ; i--){
            int num = nums[i] ;
            while(!st.isEmpty() && nums[st.peek()] <= num ){
                st.pop() ;
            }

            if(st.isEmpty()){
                result[i] = -1 ;
            }else{
                result[i] = nums[st.peek()] ;
            }

            st.push(i) ;
        }

        return result ;
    }
}