class Solution {
    public int shortestPathLength(int[][] graph) {
        int n = graph.length;
        Queue<State> q = new LinkedList<>();
        Set<String> seen = new HashSet<>();

        //put all nodes at queue
        for(int i = 0 ; i < n ; i++){
            Set<Integer> visited = new HashSet<>();
            visited.add(i);
            seen.add(i+"-"+visited);
            q.offer(new State(i, visited)) ;
        }

       int distance = 0;
       while(!q.isEmpty()){
        for(int i = q.size(); i > 0 ; i --){
            State top = q.poll();

            if(top.visited.size() == n) return distance;

            for(int next: graph[top.node]){
                Set<Integer> visited = new HashSet<>(top.visited);
                visited.add(next);
                String seenCondtion = next+"-"+visited ;
                if(!seen.contains(seenCondtion)){
                    seen.add(seenCondtion);
                    q.offer(new State(next, visited));
                }
            }
        }
        distance++ ;
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