class Solution {
    public int[] singleNumber(int[] nums) {
        int xor = 0 ;
        for(int num : nums){
            xor = xor^num  ;
        }

        int shift_position = 0 ;
        while( ((xor >> shift_position ) & 1) != 1   ){
            shift_position++ ;
        }

        int num1 = 0 ;
        int num2 = 0 ;
        for(int num : nums){
            if( ((num >> shift_position) & 1) != 1  ){
                num1 = num1 ^ num ;
            }else{
                num2 = num2 ^ num ;
            }
        }

        return new int[]{num1 , num2} ;
    }
}
