class Solution {
    public static class Project{
        int profit , capital ;
        public Project(int pro , int cap){
            profit = pro ;
            capital = cap ;
        }
    }
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length ;
        Project[] projects = new Project[n] ;
        for(int i = 0 ; i < n ; i++){
            projects[i] = new Project(profits[i] , capital[i] ) ;
        }
        Arrays.sort(projects , (x , y) -> Integer.compare(x.capital , y.capital) ) ;

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((x, y) -> y - x) ;
        int i = 0 ;
        for(int j = 0 ; j < k ; j++ ){
            while(i < n && projects[i].capital <= w  ){
                maxHeap.offer(projects[i].profit ) ;
                i++ ;
            }

            if(maxHeap.isEmpty() ){
                break ;
            }

            w += maxHeap.poll() ;
        }
        return w ;
    }
}