class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        int[] sort1 = new int[1001];
        int[] sort2 = new int[1001];
        for(int num : nums1){
            sort1[num]++ ;
        }
        for(int num : nums2){
            sort2[num]++ ;
        }
        List<Integer> list = new ArrayList<>() ;
        for(int i = 0 ; i <= 1000 ; i++){
            int count = Math.min(sort1[i] , sort2[i] ) ;
            while(count > 0){
                list.add(i) ;
                count-- ;
            }
        }

        int[] result = new int[list.size() ] ;
        int i = 0 ;
        for(int num : list){
            result[i] = num ;
            i++ ;
        }
        return result ;

    }////
}