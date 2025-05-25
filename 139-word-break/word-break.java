class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int[] cache = new int[s.length()];
        Arrays.fill(cache, -1);
        return wordBreakHelper(s, 0, wordDict, cache);
    }

    public boolean wordBreakHelper(String str, int i, List<String> dict, int[] cache) {

        if (i == str.length())
            return true;

        if (cache[i] != -1) {
            return cache[i] == 1 ? true : false;
        }

        String prefix = "";
        boolean result = false;
        for (int j = i; j < str.length(); j++) {

            prefix += str.charAt(j);

            if (dict.contains(prefix) && wordBreakHelper(str, j + 1, dict, cache)) {
                result = true;
                break;
            }
        }

        cache[i] = result ? 1 : 0;

        return result;
    }

}