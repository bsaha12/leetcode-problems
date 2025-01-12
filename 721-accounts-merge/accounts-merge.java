class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int accountsSize = accounts.size() ;
        UF uf = new UF(accountsSize) ;
        Map<String , Integer> map = new HashMap<>() ;
        int i = 0 ;
        for(List<String> list : accounts){
            int size = list.size() ;
            for(int j = 1 ; j < size ; j++){
                String mail = list.get(j) ;
                if(map.containsKey(mail)){
                    uf.union(i , map.get(mail)) ;
                }else{
                    map.put(mail , i) ;
                }
            }
            i++ ;
        }
        // create result
        Map<Integer , List<String>> resultMap = new HashMap<>() ;
        for(String email : map.keySet()){
            int rps = uf.find(map.get(email)) ;
            if(!resultMap.containsKey(rps)){
                resultMap.put(rps , new ArrayList<>() ) ;
            }
            resultMap.get(rps).add(email) ;
        }

        //sort 
        List<List<String>> mergedAccounts = new ArrayList<>() ;
        for(int group : resultMap.keySet()){
            List<String> component = resultMap.get(group) ;
            Collections.sort(component) ;
            String user = accounts.get(group).get(0) ;
            component.add(0 , user) ;
            mergedAccounts.add(component) ;
        }
        return mergedAccounts ;
    }//
}

class UF{
    int[] parent , size ;
    public UF(int len){
        parent = new int[len] ;
        size = new int[len] ;
        for(int i = 0 ; i < len ; i++){
            size[i] = 1 ;
            parent[i] = i ;
        }
    }

    public void union(int x , int y){
        int rpsX = find(x) ;
        int rpsY = find(y) ;
        if(rpsX == rpsY){
            return ;
        }

        if(size[rpsX] >= size[rpsY]){
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
}