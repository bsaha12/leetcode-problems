class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length ;
        UnionFind unionFind = new UnionFind(n) ;
        for(int i = 0 ; i < n ; i++ ){
            for(int j = i + 1 ; j < n ; j++){
                if(isConnected[i][j]  == 1){
                    unionFind.unionBySize(i , j) ;
                }
            }
        }

        Set<Integer> components = new HashSet<>() ;
        for(int i = 0 ; i < n ; i++){
            components.add(unionFind.find(i)) ;
        }

        return components.size() ;
    }//
}

class UnionFind{
    int[] size ;
    public int[] parent ;

    public UnionFind(int num){
        parent = new int[num] ;
        size = new int[num] ;
        for(int i = 0 ; i < num ; i++){
            parent[i] = i ;
            size[i] = 1 ;
        }
    }

    public void unionBySize(int node1 , int node2){
        int rps1 = find(node1) ;
        int rps2 = find(node2) ;

        if(rps1 == rps2){
            return ;
        }

        if(size[rps1] > size[rps2]){
            parent[rps2] = rps1 ;
            size[rps1] += size[rps2] ;
        }else{
            parent[rps1] = rps2 ;
            size[rps2] += size[rps1] ;
        }
    }

    public int find(int node){
        if(parent[node] != node){
            parent[node] = find(parent[node]) ;
        }

        return parent[node] ;
    }
}