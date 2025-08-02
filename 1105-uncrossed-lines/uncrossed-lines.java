class Solution {
    // int[] arr1 , arr2 ;
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        // arr1 = nums1 ;
        // arr2 = nums2 ;
        // return helper(0 , 0) ;
        int m = nums1.length ;
        int n = nums2.length ;
        int[] prev = new int[n + 1] ;

        for(int i = m - 1 ; i >= 0 ; i--){
            int[] curr = new int[n + 1] ;
            for(int j = n - 1 ; j >= 0 ; j--){
                if(nums1[i] == nums2[j]){
                    curr[j] = 1 + prev[j+1] ;
                }else{
                    curr[j] = Math.max( curr[j+1] , prev[j] ) ;
                }
            }
            prev = curr ;
        }

        return prev[0] ;
    }

    // public int helper(int i , int j){
    //     if(i == arr1.length || j == arr2.length) return 0 ;

    //     if(arr1[i] == arr2[j]) return 1 + helper(i + 1 , j + 1) ;

    //     int top = helper(i , j + 1) ;
    //     int bottom = helper( i + 1 , j) ;

    //     return Math.max(top , bottom) ;
    // }
}