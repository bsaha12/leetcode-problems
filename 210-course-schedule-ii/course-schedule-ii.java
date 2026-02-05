class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjList = new ArrayList<>() ;
        int[] inDegree = new int[numCourses] ;

        // prepare adjList
        for(int i = 0 ; i < numCourses ; i++){
            adjList.add(new ArrayList<>()) ;
        }
        for(int[] prerequisite : prerequisites  ){
            int prev = prerequisite[1] ;
            int later = prerequisite[0] ;

            adjList.get(prev).add(later) ;
            inDegree[later]++ ;
        }



        // BFS to find 
        Queue<Integer> queue = new LinkedList<>() ;
        for(int i = 0 ; i < numCourses ; i++){
            if(inDegree[i] == 0){
                queue.add(i) ;
            }
        }

        List<Integer> list = new ArrayList<>() ;
        while(!queue.isEmpty()){
            int currSize = queue.size() ;
            while(currSize > 0){
                int curr = queue.remove() ;
                for(int next : adjList.get(curr)){
                    inDegree[next]-- ;
                    if(inDegree[next] == 0){
                        queue.add(next) ;
                    }
                }
                list.add(curr) ;
                currSize-- ;
            }	
        }

        int[] result = new int[numCourses] ;
        for(int i = 0 ; i < numCourses ; i++){
            if(inDegree[i] > 0){
                return new int[]{} ;
            }

            result[i] = list.get(i) ;
        }

        return result ;
        
    }
}