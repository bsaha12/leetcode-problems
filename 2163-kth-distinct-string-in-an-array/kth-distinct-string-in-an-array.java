class Solution {
    public String kthDistinct(String[] arr, int k) {
        Map<String , Integer> map = new HashMap<>() ;
        for(String str : arr){
            map.putIfAbsent(str , 0) ;
            map.put(str , map.get(str) + 1) ;
        }

        int i = 0 ;
        for(String str : arr){
            if(map.get(str) == 1){
                i++ ;
                if(i == k){
                    return str ;
                }
            }
        }

        return "" ;
    }
}