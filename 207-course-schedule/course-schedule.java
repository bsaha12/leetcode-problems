class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjList = new ArrayList<>() ;
        for(int i = 0 ; i < numCourses ; i++){
            adjList.add(new ArrayList<>()) ;
        }
        for(int[] edge : prerequisites){
            int u = edge[0] ;
            int v = edge[1] ;
            adjList.get(u).add(v) ;
        }

        boolean result = false ;
        boolean[] visited = new boolean[numCourses] ;
        boolean[] recStack = new boolean[numCourses] ;

        for(int i = 0 ; i < numCourses ; i++){
            result = result || isCyclic(i , adjList , visited , recStack) ;
        }

        return !result ;
    }//

    boolean isCyclic(int vertex , List<List<Integer>> adjList , boolean[] visited , boolean[] recStack ){
        if(visited[vertex]){
            return false ;
        }

        // main processing
        visited[vertex] = true ;
        recStack[vertex] = true ;

        boolean result = false ;
        for(int neighbor : adjList.get(vertex)){
            if(!visited[neighbor]){
                result = result || isCyclic(neighbor , adjList , visited , recStack);
            }else if(recStack[neighbor]){
                return true ;
            }
        }
        recStack[vertex] = false ;
        return result ;
    }
}