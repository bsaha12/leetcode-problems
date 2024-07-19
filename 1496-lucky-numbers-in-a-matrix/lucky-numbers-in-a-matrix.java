class Solution {
    public List<Integer> luckyNumbers (int[][] matrix) {
        int[] minValues = new int[matrix.length] ;
        List<Integer> list = new ArrayList<>() ;
        int i = 0 ;
        for(int[] arr : matrix  ){
            //i is the current row
            int min = 0 ;
            for(int j = 0 ; j < arr.length ; j++){
                if(arr[min] > arr[j] ){
                    min = j ;
                }
            }
            // Get the row no with max value in that col i.e min
            int max = 0 ;
            for(int j = 0 ; j < matrix.length ; j++ ){
                if(matrix[j][min] >  matrix[max][min]  ){
                    max = j ;
                }
            }
            if(i == max){
                list.add(matrix[i][min] ) ;
                return list ;
            }

            i++ ;
        }
        return list ;
    }
}