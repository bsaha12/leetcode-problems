class Solution {
    // char[] arr;
    // int[] cache;

    public int numDecodings(String s) {
        char[] arr = s.toCharArray();
        // int[] cache = new int[arr.length + 1];
        // Arrays.fill(cache, -1);
        int n = arr.length;
        // cache[n] = 1;

        int oneStepBefore = 1 ;
        int twoStepBefore = 1 ;
        for (int i = n - 1; i >= 0; i--) {
            int result = 0;
            if (arr[i] != '0') {
                // result = cache[i + 1];
                // result += i + 1 < arr.length && Integer.parseInt(arr[i] + "" + arr[i + 1]) <= 26 ? cache[i + 2] : 0;
                result = oneStepBefore;
                result += i + 1 < arr.length && Integer.parseInt(arr[i] + "" + arr[i + 1]) <= 26 ? twoStepBefore : 0;
            }

            // cache[i] = result;
            twoStepBefore = oneStepBefore ;
            oneStepBefore = result ;
        }

        return oneStepBefore ;

        // return cache[0];
        // return helper(0);
    }

    // function representing number of ways to decode s.substring(i) ;
    // public int helper(int i) {
    //     if( i == arr.length) return 1 ;

    //     if (cache[i] != -1)
    //         return cache[i];

    //     if(arr[i] == '0') return 0 ;

    //     int result = helper(i + 1) ;

    //     result += i+1 < arr.length && Integer.parseInt(arr[i]+""+arr[i+1]) <= 26 ?helper(i + 2) : 0; 

    //     return cache[i] = result;
    // }

}