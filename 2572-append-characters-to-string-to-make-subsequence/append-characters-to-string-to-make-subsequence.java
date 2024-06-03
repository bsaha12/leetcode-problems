class Solution {
    char[] arr1, arr2;

    public int appendCharacters(String s, String t) {
        arr1 = s.toCharArray();
        arr2 = t.toCharArray();
        int len = findCommonLength();
        return arr2.length - len;
    }

    int findCommonLength() {
        // if (x == arr1.length || y == arr2.length)
        //     return 0;

        // if (dp[x][y] != -1)
        //     return dp[x][y];

        // int result = 0;
        // if (arr1[x] == arr2[y]) {
        //     result = 1 + findCommonLength(x + 1, y + 1);
        // }

        // result = Math.max(findCommonLength(x + 1, y), result);

        // dp[x][y] = result;
        // return result;
        int result = 0;
        int i = 0 , j = 0 ;
        while(i < arr1.length && j < arr2.length){
            if(arr1[i] == arr2[j] ){
                j++ ;
                result++ ;
            }
            i++ ;
        }
        return result ;
    }
}
