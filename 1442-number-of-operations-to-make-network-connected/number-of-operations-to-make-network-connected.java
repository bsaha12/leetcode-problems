class Solution {
    public int makeConnected(int n, int[][] connections) {
        UnionFind uf = new UnionFind(n) ;
        int rc = 0 ;
        for(int[] connection : connections){
            boolean isUnion = uf.union(connection[0] , connection[1]) ;
            if(!isUnion){
                rc++ ;
            }
        }

        int groups = 0 ;
        for(int i = 0 ; i < n ; i++){
            if(i == uf.find(i)){
                groups++ ;
            }
        }

        if( rc < groups - 1 ){
            return -1 ;
        }

        return groups - 1 ;
    }
}

class UnionFind{

    int[] size , parent ;
    public UnionFind(int n){
        size = new int[n] ;
        parent = new int[n] ;
        for(int i = 0 ; i < n ; i++){
            size[i] = 1 ;
            parent[i] = i ;
        }
    }

    public boolean union(int x , int y){
        int rpsX = find(x) ;
        int rpsY = find(y) ;

        if(rpsX == rpsY){
            return false ;
        }

        if(size[rpsX] > size[rpsY]){
            size[rpsX] += size[rpsY] ;
            parent[rpsY] = rpsX ;
        }else{
            size[rpsY] += size[rpsX] ;
            parent[rpsX] = rpsY ;
        }

        return true ;
    }

    public int find(int x){
        if(x != parent[x]){
            parent[x] = find(parent[x]) ;
        }

        return parent[x] ;
    }
}