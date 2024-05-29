class Solution {
    public int numSteps(String s) {
        char[] arr = ('0' + s).toCharArray();
        int left = 1;
        int right = arr.length - 1;
        int steps = 0;
        while (right - left + 1 > 1) {
            if (arr[right] == '1') {
                int carry = 1;
                for (int i = right; i >= left; i--) {
                    if (arr[i] == '1' && carry == 1) {
                        arr[i] = '0';
                        carry = 1;
                    } else if (arr[i] == '0' && carry == 0) {
                        arr[i] = '0';
                    } else {
                        arr[i] = '1';
                        carry = 0;
                    }
                }
                if (carry == 1) {
                    left--;
                    arr[left] = '1';
                }
                steps++;
            } else {
                for (int i = right; i > left; i--) {
                    arr[i] = arr[i - 1];
                }
                left++;
                steps++;
            }
        }
        return steps;
    }//
}