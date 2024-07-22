class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        // int[] indices = new int[names.length] ;
        ArrayList<Integer> indices = new ArrayList<>() ;
        for(int i = 0 ; i < names.length ; i++){
            indices.add(i) ;
        }
        Collections.sort(indices , (i , j) -> Integer.compare(heights[j] , heights[i] ) ) ;
        String[] result = new String[names.length] ;
        for(int i = 0 ; i < result.length ; i++){
            result[i] = names[indices.get(i) ] ;
        }
        return result ;
    }
}