class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // preparing adjacency list
        List<List<Integer>> adjList = new ArrayList<>() ;

        for(int i = 0 ; i < numCourses ; i++){
            adjList.add(new ArrayList<>()) ;
        }

        for(int[] edge : prerequisites ){
            int from = edge[1] ;
            int to = edge[0] ;

            adjList.get(from).add(to) ;
        }

        boolean[] visited = new boolean[numCourses] ;
        boolean[] recStack = new boolean[numCourses] ;

        boolean isCyclicGraph = false ;
        for(int i = 0 ; i < numCourses ; i++){
            if(!visited[i]){
                isCyclicGraph = isCyclicGraph || isCyclic(i , adjList , visited , recStack) ;
            }
        }

        return !isCyclicGraph ;
    }

    public boolean isCyclic(int node, List<List<Integer>> adjList, boolean[] visited, boolean[] recStack){

        visited[node] = true ;
        recStack[node] = true ;

        boolean isCyclicGraph = false;
        for(int next : adjList.get(node)){
            if(!visited[next]){
                isCyclicGraph = isCyclicGraph || isCyclic(next, adjList, visited, recStack);
            }else if(recStack[next]){
                return true ;
            }
        }

        recStack[node] = false;

        return isCyclicGraph ;
    }
}