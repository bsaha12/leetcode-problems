class Solution {
    char[] arr;
    int[] cache;

    public int numDecodings(String s) {
        arr = s.toCharArray();
        cache = new int[arr.length + 1];
        Arrays.fill(cache, -1);
        return helper(0);
    }

    public int helper(int i) {
        if( i == arr.length) return 1 ;

        if (cache[i] != -1)
            return cache[i];

        if(arr[i] == '0') return 0 ;

        int result = helper(i + 1) ;

        result += i+1 < arr.length && Integer.parseInt(arr[i]+""+arr[i+1]) <= 26 ?helper(i + 2) : 0; 

        return cache[i] = result;
    }

}