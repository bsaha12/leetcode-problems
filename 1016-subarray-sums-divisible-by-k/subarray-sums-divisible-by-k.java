class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        Map<Integer , Integer> map = new HashMap<Integer , Integer>() ;
        int sum = 0 ;
        int count = 0 ;
        map.put(0 , 1) ;
        for(int num : nums){
            sum += num ;
            int rem = sum % k ;
            if(rem < 0) rem += k ;
            map.putIfAbsent(rem , 0) ;
            int val = map.get(rem) ;
            count += val ;
            map.put(rem , val + 1) ; 
        }
        return count ;
    }
}

