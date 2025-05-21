class Solution {
    public int longestValidParentheses(String str) {
        if (str.length() == 0)
            return 0;
        
        int max = 0;
        Stack<Integer> st = new Stack<>();
        st.push(-1);
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ')') { // close
                st.pop();

                if (st.isEmpty())
                    st.push(i);
                else
                    max = Math.max(max, i - st.peek());
            } else { // open
                st.push(i);
            }
        }
        return max;

    }
}