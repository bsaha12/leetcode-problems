class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> result = new ArrayList<>() ;
        if( n == 1){
            result.add(0) ;
            return result ;
        }
        List<List<Integer>> adjList = new ArrayList<>() ;
        int[] degree = new int[n] ; 
        for(int i = 0 ; i < n ; i++){
            adjList.add(new ArrayList()) ;
        }
        for(int[] edge : edges){
            int u = edge[0] ;
            int v = edge[1] ;
            adjList.get(u).add(v) ;
            adjList.get(v).add(u) ;
            degree[u]++ ;
            degree[v]++ ;
        }
        Queue<Integer> leaves = new LinkedList<>() ;
        for(int i = 0 ; i < n ; i++){
            if(adjList.get(i).size() == 1){
                leaves.add(i) ;
            }
        }
        int verticesLeft = n ;
        while(verticesLeft > 2){
            int currSize = leaves.size() ;

            for(int i = 0 ; i < currSize ; i++){
                int leaf = leaves.poll() ;
                for(int neighbor : adjList.get(leaf)){
                    degree[neighbor]-- ;
                    if(degree[neighbor] == 1){
                        leaves.add(neighbor) ;
                    }
                }
            }
            
            verticesLeft -= currSize ;
        }

        while(!leaves.isEmpty()){
            result.add( leaves.poll() );
        }
        return result ;
    }
}