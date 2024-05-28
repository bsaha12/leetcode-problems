class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        int n = s.length();
        int result = 0;
        int i = 0;
        int j = 0;
        int sum = 0;
        while (j < n) {
            sum += Math.abs(s.charAt(j) - t.charAt(j));
            while (sum > maxCost) {
                sum -= Math.abs(s.charAt(i) - t.charAt(i));
                i++;
            }
            result = Math.max(result, j - i + 1);
            j++ ;
        }
        return result;
    }
}