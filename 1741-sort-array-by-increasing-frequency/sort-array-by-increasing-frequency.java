class Solution {
    public int[] frequencySort(int[] nums) {
        Map<Integer , Integer> map = new HashMap<>() ;
        Integer[] numAsObj = new Integer[nums.length] ;
        int i = 0 ;
        for(int num : nums){
            map.put(num , map.getOrDefault(num , 0) + 1) ;
            numAsObj[i] = num ;
            i++ ;
        }      
        Arrays.sort(numAsObj , (a , b) ->{
            int iFreq = map.get(a) ;
            int jFreq = map.get(b) ;

            if(iFreq > jFreq){
                return 1;
            }
            if(iFreq < jFreq){
                return -1;
            }

            return -1*Integer.compare(a , b) ;
        }) ;

        for(i = 0 ; i < nums.length ; i++){
            nums[i] = numAsObj[i] ;
        } 
        return nums ;
    }
}