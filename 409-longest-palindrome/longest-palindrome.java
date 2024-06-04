class Solution {
    public int longestPalindrome(String s) {
        char[] arr = s.toCharArray();
        int[] small = new int[26];
        int[] cap = new int[26];
        for (char ch : arr) {
            if (ch >= 'a' && ch <= 'z') {
                small[ch - 'a']++;
            } else {
                cap[ch - 'A']++;
            }
        }

        int result = 0;
        int mid = 0;
        for (int i = 0; i < 26; i++) {
            result += ((small[i] / 2) * 2) + ((cap[i] / 2) * 2) ;
            if (mid == 0 && small[i] % 2 != 0) {
                mid = 1;
            }
            if (mid == 0 && cap[i] % 2 != 0) {
                mid = 1;
            }
        }
        return result + mid;
    }///
}