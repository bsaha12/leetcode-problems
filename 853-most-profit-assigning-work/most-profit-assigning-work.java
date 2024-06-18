class Solution {
    static class Job{
        int diff , profit ;
        public Job(int d , int p){
            diff = d ;
            profit = p;
        }
    }

    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int n = profit.length ;
        Job[] jobs = new Job[n] ;
        for(int i = 0 ; i < n ; i++){
            jobs[i] = new Job(difficulty[i] , profit[i] ) ;
        }
       // sorting array based on difficulty
        Arrays.sort(jobs , new Comparator<Job>(){
            public int compare(Job x , Job y){
                if(x.diff < y.diff ) return -1 ;
                else if(x.diff > y.diff) return 1 ;
                else return Integer.compare(x.profit , y.profit) ;
            }
        } );

        Arrays.sort(worker) ;
        int m = worker.length ;
        int i = 0 , j = 0 ;
        int maxProfit = 0 ;
        int result = 0 ;
        while(i < n && j < m){
            while(i < n  && worker[j] >= jobs[i].diff  ){
                maxProfit = Math.max(maxProfit , jobs[i].profit ) ;
                i++ ;
            }
            result += maxProfit ;
            j++ ;
        } 
        while(j < m){
            result += maxProfit ;
            j++ ;
        }
        return result ;
    }
}