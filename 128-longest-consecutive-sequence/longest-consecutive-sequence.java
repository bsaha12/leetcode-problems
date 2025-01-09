class Solution {
    public int longestConsecutive(int[] nums) {
        int maxLen = 0 ;
        Map<Integer , Integer> map = new HashMap<>() ;
        int i = 0 ;
        UF uf = new UF(nums.length) ;
        for(int num : nums){
            if(map.containsKey(num)){
                continue ;
            }

            if(map.containsKey(num - 1)){
                uf.union(i , map.get(num-1)) ;
            }

            if(map.containsKey(num + 1)){
                uf.union(i , map.get(num + 1)) ;
            }

            map.put(num , i) ;
            i++ ;
        }

        return uf.findLargestSetSize() ;
    }
}

class UF{
    int[] size , parent ;
    public UF(int len){
        size = new int[len] ;
        parent = new int[len] ;
        for(int i = 0 ; i < len ; i++){
            parent[i] = i ;
            size[i] = 1 ;
        }
    }

    public void union(int x , int y){
        int rpsX = find(x) ;
        int rpsY = find(y) ;

        if(rpsX == rpsY){
            return ;
        }

        if(size[rpsX] > size[rpsY]){
            parent[rpsY] = rpsX ;
            size[rpsX] += size[rpsY] ;
        }else{
            parent[rpsX] = rpsY ;
            size[rpsY] += size[rpsX] ;
        }
    }

    public int find(int x){
        if(x != parent[x]){
            parent[x] = find(parent[x]) ;
        }
        return parent[x] ;
    }

    public int findLargestSetSize(){
        int maxSize = 0 ;
        for(int i = 0 ; i < size.length ; i++){
            // if(parent[i] == i){
                maxSize = Math.max(maxSize , size[i]) ;
            // }
        }
        return maxSize ;
    }
}