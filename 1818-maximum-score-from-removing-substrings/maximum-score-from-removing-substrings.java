class Solution {
    public int maximumGain(String s, int x, int y) {
        if (x < y) {
            int temp = x;
            x = y;
            y = temp;
            s = new StringBuilder(s).reverse().toString();
        }
        char[] arr = s.toCharArray();
        int aCount = 0;
        int bCount = 0;
        int score = 0;
        for (char ch : arr) {
            if (ch == 'a') {
                aCount++;
            } else if (ch == 'b') {
                if (aCount > 0) {
                    aCount--;
                    score += x;
                } else {
                    bCount++;
                }
            } else {
                score += Math.min(aCount, bCount) * y;
                aCount = 0;
                bCount = 0;
            }
        }
        score += Math.min(aCount, bCount) * y;
        return score;
    }///////
}