class Solution {
    public int minTaps(int n, int[] ranges) {
        int[] arr = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            if (ranges[i] == 0)
                continue;
            int left = Math.max(0, i - ranges[i]);
            int right = Math.min(n, i + ranges[i]);
            arr[left] = Math.max(arr[left], right);
        }
        // for(int temp : arr){
        //     System.out.println(temp) ;
        // }
        int count = 0, pos = 0 , lastReach = arr[0] ;
        if(lastReach == n) return 1 ;
        while (pos < n && lastReach < n) {
            count++ ;
            int next = findNext(pos , arr , lastReach ) ;
            System.out.println("lastReach : " + lastReach + " next : "+ next) ;
            if(next <= lastReach) return -1 ;
            pos = lastReach + 1 ;
            lastReach = next ;
        }
        return count + 1;
    }////
    public int findNext(int pos , int[] arr  , int lastReach){
        int maxReach = lastReach ;
        while(pos <= lastReach){
            maxReach = Math.max(maxReach , arr[pos] ) ;
            pos++ ;
        }
        return maxReach ;
    }////
}