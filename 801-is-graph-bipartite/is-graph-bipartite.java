class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length ;

        int[] colour = new int[n];
        Arrays.fill(colour, -1);

        Queue<Integer> q = new LinkedList<>();

        // BFS
        for(int i = 0 ; i < n ; i++){
            if(colour[i] == -1){
                q.add(i);
                colour[i] = 0;

                while(!q.isEmpty()){
                    int curr = q.poll();
                    for(int next : graph[curr]){
                        int nextColour = 1 - colour[curr];
                        if(colour[next] == -1){
                            colour[next] = nextColour;
                            q.add(next);
                        }else if(colour[next] != nextColour){
                            return false;
                        }
                    }
                }
            }
        }

        return true;
    }
}