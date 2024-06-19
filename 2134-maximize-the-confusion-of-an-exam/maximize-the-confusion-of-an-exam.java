class Solution {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        char[] arr = answerKey.toCharArray();
        int i = 0, j = 0;
        int n = arr.length;
        int fCount = 0, pass1 = 0;
        while (i < n && j < n) {
            if (fCount <= k) {
                if (arr[j] == 'F') {
                    fCount++;
                }
                if (fCount <= k)pass1 = Math.max(pass1, j - i + 1);
                j++;
            } else {
                while (fCount > k && i < n) {
                    if (arr[i] == 'F') {
                        fCount--;
                    }
                    if (i == j) {
                        j++;
                    }
                    i++;
                }
            }
        }
        i = 0;
        j = 0;
        int pass2 = 0, tCount = 0;
        while (i < n && j < n) {
            if (tCount <= k) {
                if (arr[j] == 'T') {
                    tCount++;
                }
                if (tCount <= k) pass2 = Math.max(pass2, j - i + 1);
                j++;
            } else {
                while (tCount > k && i < n) {
                    if (arr[i] == 'T') {
                        tCount--;
                    }
                    if (i == j) {
                        j++;
                    }
                    i++;
                }
            }
        }

        return Math.max(pass2 , pass1);
    }////

}