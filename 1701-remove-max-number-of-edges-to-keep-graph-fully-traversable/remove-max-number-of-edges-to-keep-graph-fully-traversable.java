class Solution {
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        // sorting
        Arrays.sort(edges , (int[] a1 , int[] a2) -> {
            if(a1[0] == 3){
                return -1 ;
            }
            if(a2[0] == 3){
                return 1 ;
            }
            return 0 ;
        } );

        // intialize
        UnionBySize uA = new UnionBySize(n+1) ;
        UnionBySize uB = new UnionBySize(n+1) ;
        int connectedComponentsA = n ;
        int connectedComponentsB = n ;
        int remove = 0 ;

        for(int[] arr : edges){
            int type = arr[0] ;
            int u = arr[1] ;
            int v = arr[2] ;

            if(type == 3){
                boolean mergeA = uA.union(u ,v) ;
                boolean mergeB = uB.union(u, v) ;

                if(mergeA){
                    connectedComponentsA-- ;
                }

                if(mergeB){
                    connectedComponentsB-- ;
                }

                if(mergeA == false && mergeB == false){
                    remove++ ;
                }
            }else if(type == 1 ){
                boolean mergeA = uA.union(u,v) ;
                if(mergeA){
                    connectedComponentsA-- ;
                }else{
                    remove++ ;
                }

            }else{
                boolean mergeB = uB.union(u , v);
                if(mergeB){
                    connectedComponentsB-- ;
                }else{
                    remove++ ;
                }
            }
        }//

        if( connectedComponentsA != 1 || connectedComponentsB != 1){
            return -1 ;
        }

        return remove ;
    }
}

class UnionBySize{
    int[] parent , size ;
    // constructor
    public UnionBySize(int n){
        size = new int[n] ;
        parent = new int[n] ;
        for(int i = 0 ; i < n ; i++){
            size[i] = 1 ;
            parent[i] = i ;
        }
    }
    // union
    public boolean union(int u , int v){
        int rpsU = find(u) ;
        int rpsV = find(v) ;

        if(rpsU == rpsV){
            return false;
        }

        if(size[rpsU] > size[rpsV]){
            parent[rpsV] = rpsU ;
            size[rpsU] += size[rpsV] ;
        }else{
            parent[rpsU] = rpsV ;
            size[rpsV] += size[rpsU] ;
        }

        return true ;
    }
    // find
    public int find(int x){
        if(x != parent[x]){
            parent[x] = find(parent[x]) ;
        }
        return parent[x] ;
    }
}