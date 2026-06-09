class Solution {
    public int shortestPathLength(int[][] graph) {
    //     int n = graph.length;
    //     Queue<State> q = new LinkedList<>();
    //     Set<String> seen = new HashSet<>();

    //     //put all nodes at queue
    //     for(int i = 0 ; i < n ; i++){
    //         Set<Integer> visited = new HashSet<>();
    //         visited.add(i);
    //         seen.add(i+"-"+visited);
    //         q.offer(new State(i, visited));
    //     }

    //    int distance = 0;
    //    while(!q.isEmpty()){
    //     for(int i = q.size(); i > 0 ; i --){
    //         State top = q.poll();

    //         if(top.visited.size() == n) return distance;

    //         for(int next: graph[top.node]){
    //             Set<Integer> visited = new HashSet<>(top.visited);
    //             visited.add(next);
    //             String seenCondtion = next+"-"+visited ;
    //             if(!seen.contains(seenCondtion)){
    //                 seen.add(seenCondtion);
    //                 q.offer(new State(next, visited));
    //             }
    //         }
    //     }
    //     distance++ ;
    //    }
    //    return -1;

        int n = graph.length;
        Queue<int[]> q = new LinkedList<>() ;
        boolean[][] visited = new boolean[n][1 << n];

        for(int i = 0 ; i < n ; i++){
            q.offer(new int[]{i, 1 << i});
            visited[i][1 << i] = true;
        }

        int distance = 0;
        // BFS
        while(!q.isEmpty()){
            for(int i = q.size(); i > 0 ; i--){
                int[] top = q.poll() ;
                int node = top[0];
                int maskedState = top[1];

                // check if all the node is visited,then return true
                if(maskedState == (1 << n) - 1) return distance;

                //visit neighbors if not already visited
                for(int next: graph[node]){
                    int nextMaskedState = maskedState | (1 << next) ;
                    if(!visited[next][nextMaskedState]){
                        visited[next][nextMaskedState] = true ;
                        q.offer(new int[]{next, nextMaskedState });
                    }
                }

            }
            distance++;
        }

        return -1;
    }
}

class State{
    int node ;
    Set<Integer> visited ;

    State(int node, Set<Integer> visited){
        this.node = node;
        this.visited = visited;
    }

}