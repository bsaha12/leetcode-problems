class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        int n = tokens.length;

        for (int i = 0; i < n; i++) {
            String token = tokens[i];
            int rightElem;
            int leftElem;
            int result = 0;
            switch (token) {
                case "+":
                    rightElem = st.pop();
                    leftElem = st.pop();
                    result = leftElem + rightElem;
                    break;
                case "-":
                    rightElem = st.pop();
                    leftElem = st.pop();
                    result = leftElem - rightElem;
                    break;
                case "*":
                    rightElem = st.pop();
                    leftElem = st.pop();
                    result = leftElem * rightElem;
                    break;
                case "/":
                    rightElem = st.pop();
                    leftElem = st.pop();
                    result = leftElem / rightElem;
                    break;
                default:
                    st.push(Integer.parseInt(token));
                    continue;
            }
            st.push(result);
        }

        return st.pop();
    }
}