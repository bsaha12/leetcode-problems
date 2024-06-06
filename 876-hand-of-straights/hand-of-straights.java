class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if(hand.length % groupSize != 0) return false ;
        Arrays.sort(hand) ;
        Map<Integer,Integer> map = new HashMap<>() ;
        for(int num : hand){
            map.put(num , map.getOrDefault(num , 0) + 1 ) ;
        }
        for(int num : hand ){
            if(map.get(num) > 0 ){
                int k = 0 ;
                while(k < groupSize){
                    if(map.get(num + k) != null && map.get(num + k) > 0 ){
                        map.put(num + k , map.get(num + k) - 1 ) ;
                    }else{
                        return false ;
                    }
                    k++ ;
                }
            }
        }
        return true ;
    }
}