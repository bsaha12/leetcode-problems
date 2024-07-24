class Solution {
    public int[] sortJumbled(int[] mapping, int[] nums) {
        Integer[][] mappedArray = new Integer[nums.length][3];
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            mappedArray[i][0] = mappedValue(num, mapping);
            mappedArray[i][1] = i;
            mappedArray[i][2] = num;
        }
        Arrays.sort(mappedArray, (arr1, arr2) -> Integer.compare(arr1[0], arr2[0]));
        for (int i = 0; i < nums.length; i++) {
            nums[i] = mappedArray[i][2];
        }
        return nums;
    }//

    int mappedValue(int num, int[] mapping) {
        StringBuilder str = new StringBuilder() ;
        if(num == 0 ){
            return mapping[0] ;
        }
        while(num > 0){
            int rem = num % 10 ;
            str.append( mapping[rem] ) ;
            num = num / 10 ;
        }
        
        return Integer.parseInt(str.reverse().toString()) ;
    }///
}