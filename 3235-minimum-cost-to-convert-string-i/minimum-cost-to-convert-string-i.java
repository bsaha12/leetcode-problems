class Solution {
    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        ///First structure the given input into graphs
        //make an adjacency list
        List<int[]>[] adjList = new ArrayList[26] ;
        for(int i = 0 ; i < 26 ; i++){
            adjList[i] = new ArrayList<>() ;
        }

        int n = original.length ;
        for(int i = 0 ; i < n ; i++){
            char u = original[i] ;
            char v = changed[i] ;
            int weight = cost[i] ;
            adjList[u - 'a'].add(new int[]{v - 'a' , weight}) ;
        }

        ////Find all possibe shortest paths(weights) from each character to another
        //start from each alphabet(e.g. a , b ..) one by one 
        // and get shortest weighted path to all other alphabets
        long[][] weights = new long[26][26] ;
        for(int i = 0 ; i < 26 ; i++ ){
            weights[i] = dijkstra(i , adjList) ;
        }


        ///Now we have possible weights to reach from one alphabets to another
        int len = source.length() ;
        long minCost = 0 ;
        for(int i = 0 ; i < len ; i++){
            char start = source.charAt(i) ;
            char dest = target.charAt(i) ;
            if(start != dest){
                long currCost = weights[start - 'a'][dest - 'a'] ;
                if(currCost == -1) return -1 ;
                minCost += currCost;
            }
        }
        return minCost ;
    }////
    // main dijkstra's algorithm to get weights for al possible destinations from
    // a starting point (e.g. a or b)
    long[] dijkstra(int start , List<int[]>[] adjList){
        PriorityQueue<Pair<Integer , Long>> queue = new PriorityQueue<>( (pair1 , pair2)->Long.compare(pair1.getValue() , pair2.getValue()) ) ;
        queue.offer(new Pair(start , 0L) );

        long[] minCosts = new long[26] ;
        Arrays.fill( minCosts , -1) ;
        while(!queue.isEmpty()){
            Pair<Integer , Long> currNode = queue.poll() ;
            int currChar = currNode.getKey() ;
            long currCost = currNode.getValue() ;
            // if(minCosts[currChar] != -1 && minCosts[currChar] < currCost ){
            //     continue ;
            // }

            for(int[] arr : adjList[currChar] ){
                int nextChar = arr[0] ;
                long nextAbsoluteCost = arr[1] ;

                long nextCost = nextAbsoluteCost + currCost ;
                if(minCosts[nextChar] == -1 || minCosts[nextChar] > nextCost ){
                    minCosts[nextChar] = nextCost ;
                    queue.offer(new Pair<>(nextChar , nextCost)) ;
                }
                
            }
        }
        return minCosts ;
    }/////
}