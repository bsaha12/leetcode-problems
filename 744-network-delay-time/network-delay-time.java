class Solution {
    int[][] edges ;
    List<List<Integer>>[] adjList ;
    public int networkDelayTime(int[][] times, int n, int k) {
        edges = times ;
        adjList = new List[n + 1] ;
        int[] weight = new int[n + 1] ;
        
        for(int i = 0 ; i < n + 1 ; i++){
            adjList[i] = new ArrayList<>() ;
            weight[i] = Integer.MAX_VALUE ;
        }

        // adjList creation
        createAdjList() ;

        Queue<Node> queue = new LinkedList<>() ;
        Set<Integer> set = new HashSet<>() ;

        weight[k] = 0 ;
        Node curr = new Node(0 , k) ;
        queue.add(curr) ;

        // Start BFS
        while(queue.size() > 0){
            Node node = queue.remove() ;
            int distance = node.distance ;
            int value = node.value ;

            set.add(value) ;
            // System.out.println("Value : "+  value) ;
            // System.out.println("Distance : "+  distance) ;
            // System.out.println("Diatance : " + adjList[value]) ;

            for(List<Integer> list : adjList[value]){
                int nextNodeValue = list.get(0) ;
                int nextNodePathWeight = list.get(1) ;
                // System.out.println("Next Node Value : " + nextNodeValue) ;
                // System.out.println("Next Path weight : " + nextNodePathWeight) ;

                if(weight[nextNodeValue] > nextNodePathWeight + distance){
                    weight[nextNodeValue] = nextNodePathWeight + distance ;
                    Node currNode = new Node(weight[nextNodeValue],nextNodeValue);
                    queue.add(currNode) ;
                }
            }

        }


        // minimum time calculation
        // System.out.println(set.size()) ;
        if(set.size() < n) return -1 ;
        int result = 0 ;
        for(int i = 1 ; i <= n ; i++ ){
            int currWeight = weight[i] ;
            result = Math.max(currWeight , result) ;
        }

        return result ;
    }

    public void createAdjList(){
        for(int[] edge : edges){
            int start = edge[0] ;
            int end = edge[1] ;
            int weight = edge[2] ;
            List<Integer> list = new ArrayList<>() ;
            list.add(end) ;
            list.add(weight) ;
            adjList[start].add(list) ;
        }
    }
}//

class Node{
  int distance ;
  int value ;

  public Node(int dis , int va){
    distance = dis ;
    value = va ;
  }

}