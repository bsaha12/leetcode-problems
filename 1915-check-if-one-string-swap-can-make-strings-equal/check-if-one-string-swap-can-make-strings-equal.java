class Solution {
    public boolean areAlmostEqual(String str1, String str2) {

        if (str1.length() != str2.length())
            return false;

        int first = -1, second = -1, count = 0;

        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                if (count == 0)
                    first = i;
                else if (count == 1)
                    second = i;
                else
                    return false;

                count++;
            }
        }

        if (count == 0)
            return true;

        return count == 2 && str1.charAt(first) == str2.charAt(second) && str1.charAt(second) == str2.charAt(first);

    }
}