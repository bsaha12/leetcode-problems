class Solution {
    int[] parent ;
    int[] weight ;
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length ;
        parent = new int[n] ;
        weight = new int[n] ;
        for(int i = 0 ; i < n ; i++){
            parent[i] = i ;
            weight[i] = 1 ;
        }
        for(int[] edge : edges){
            if(!union(edge[0] - 1 , edge[1] - 1)){
                return edge ;
            }
        }
        return null ;
    }

    public boolean union(int x , int y ){
        int resX = find(x) ;
        int resY = find(y) ;
        if(resX == resY) return false ;
        if(weight[resX] > weight[resY] ){
            parent[resY] = resX ;
            weight[resX] += weight[resY] ;
        }else{
            parent[resX] = resY ;
            weight[resY] += weight[resX] ;
        }
        return true ;
    }

    public int find(int x){
        if(parent[x] != x){
            parent[x] = find(parent[x]) ;
        }
        return parent[x] ;
    }
}