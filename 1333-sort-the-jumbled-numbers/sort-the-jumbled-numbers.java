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
        if(num == 0 ){
            return mapping[0] ;
        }
        int mappedValue = 0 ;
        int place = 1 ;
        while(num > 0){
            mappedValue += place*mapping[num % 10] ;
            place = place*10 ;
            num = num / 10 ;
        }
        
        return mappedValue ;
    }///
}