class Solution {
    public int numSteps(String s) {
        char[] arr = s.toCharArray() ;
        int carry = 0;
        int steps = 0 ;
        for(int i = arr.length - 1 ; i > 0 ; i--){
            if(  arr[i] - '0' + carry == 1 ){
                steps += 2;
                carry = 1 ;
            }else{
                steps++ ;
            }
        }
        return steps + carry ;
    }
}