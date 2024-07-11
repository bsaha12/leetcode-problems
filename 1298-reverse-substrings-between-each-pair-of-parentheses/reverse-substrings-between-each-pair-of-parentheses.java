class Solution {
    char[] arr;

    public String reverseParentheses(String s) {
        StringBuilder result = new StringBuilder();
        arr = s.toCharArray();
        int open = 0;
        for (int i = 0; i < arr.length; i++) {
            char ch = arr[i];
            if (ch >= 'a' && ch <= 'z') {
                if (open == 0)
                    result.append(ch);
            } else if (ch == '(') {
                if (open == 0)
                    result.append(reverseStringWithinParenthesis(i));
                open++;
            } else {
                open--;
            }
        }
        return result.toString();
    }///

    String reverseStringWithinParenthesis(int pos) {
        pos++;
        int open = 1;
        StringBuilder result = new StringBuilder();
        for (int i = pos; i < arr.length; i++) {
            if (open == 0) {
                break;
            }
            char ch = arr[i];
            if (ch >= 'a' && ch <= 'z') {
                if (open == 1)
                    result.append(ch);
            } else if (ch == '(') {
                if (open == 1)
                    result.append(reverseStringWithinParenthesis(i));
                open++;
            } else {
                open--;
            }
        }
        return result.reverse().toString();
    }///

}