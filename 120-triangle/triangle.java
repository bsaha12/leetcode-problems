class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int len = triangle.size() ;
        List<Integer> dp = triangle.get(len - 1) ;
        // System.out.println(dp) ;

        for(int i = len - 2 ; i >= 0 ; i--){
            List<Integer> curr = triangle.get(i) ;
            int currLen = curr.size() ;
            // System.out.println(curr) ;
            // System.out.println("Curr Len :" + currLen) ;

            for(int j = 0 ; j < currLen ; j++ ){
                int val = curr.get(j) ;
                int justBelow = dp.get(j) ;
                int belowRight = dp.get(j + 1) ;

                int minValue = val + Math.min(justBelow , belowRight) ;
                curr.set(j , minValue) ;
            }

            dp = curr ;
        }

        return dp.get(0) ;
    }
}