class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals , (a , b) -> {
            return Integer.compare(a[0] , b[0]) ;
        }) ;

        LinkedList<int[]> merged = new LinkedList<>();

        for(int[] interval : intervals){
            int start = interval[0] ;
            int end = interval[1] ;

            if(merged.isEmpty()){
                merged.add(interval) ;
            }else{
                int[] lastElement = merged.getLast() ;
                if(lastElement[1] >= start){
                    if(lastElement[1] < end) lastElement[1] = end ;
                }else{
                    merged.add(interval) ;
                }
            }

            // System.out.println(merged.getLast().toString()) ;
        }

        return merged.toArray(new int[merged.size()][2]) ;
    }
}