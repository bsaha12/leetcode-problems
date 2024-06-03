class Solution {
    public int appendCharacters(String s, String t) {
        char[] arr1 = s.toCharArray() ;
        char[] arr2 = t.toCharArray() ;
        int result = arr2.length;
        int i = 0 , j = 0 ;
        while(i < arr1.length && j < arr2.length ){
            if(arr1[i] == arr2[j] ){
                j++ ;
                result-- ;
            }
            i++ ;
        }
        return  result;
    }
}
