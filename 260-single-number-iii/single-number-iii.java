// class Solution {
//     public int[] singleNumber(int[] nums) {
//         if(n)
//         int xor = 0 ;
//         for(int num : nums){
//             xor = xor^num  ;
//         }

//         int shift_position = 0 ;
//         while( ((xor >> shift_position ) & 1) != 1   ){
//             shift_position++ ;
//         }

//         int num1 = 0 ;
//         int num2 = 0 ;
//         for(int num : nums){
//             if( ((num1 >> shift_position) & 1) != 1  ){
//                 num1 = num1 ^ num ;
//             }else{
//                 num2 = num2 ^ num ;
//             }
//         }

//         return new int[]{num1 , num2} ;
//     }
// }

class Solution {
    public int[] singleNumber(int[] nums) {
        int overall_xor = 0;
        for (int n : nums) {
            overall_xor ^= n;
        }

        int first_group_xor = 0;
        int second_group_xor = 0;

        int bit_pos_dif = 0;
        while (((overall_xor >> bit_pos_dif) & 1) != 1) {
            bit_pos_dif++;
        }

        for (int num : nums) {
            if (((num >> bit_pos_dif) & 1) == 1) {
                first_group_xor ^= num;
            } else {
                second_group_xor ^= num;
            }
        }

        return new int[] {first_group_xor, second_group_xor};
    }
}