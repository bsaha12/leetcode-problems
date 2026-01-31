class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        // first get the next greater elements of each element in nums2
        Map<Integer,Integer> map = new HashMap<>() ;
        Stack<Integer> st = new Stack<>() ;
        for(int i = nums2.length - 1 ; i >= 0 ; i--){
            int num = nums2[i];

            // if stack is not empty && the top element is less than or equal to current element
            while(!st.isEmpty() && nums2[st.peek()] <= num){ // 4 , 4 // 3 , 4 // 5 , 4
                st.pop() ;
            }

            // fill the map
            if(st.isEmpty()){
                map.put(num , -1 ) ;
            }else{
                map.put(num , nums2[st.peek()]);
            }

            // fill the current element
            st.push(i) ;
        }


        // fill up the result array
        int[] result = new int[nums1.length] ;
        for(int i = 0 ; i < nums1.length ; i++){
            int num = nums1[i] ;
            result[i] = map.get(num) ;
        }

        return result ;
    }
}