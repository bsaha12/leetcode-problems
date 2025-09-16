class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>() ;
        int freshCount = 0 ;
        int m = grid.length ;
        int n = grid[0].length ;
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                if(grid[i][j] == 1) freshCount++ ;
                else if(grid[i][j] == 2) queue.add(new int[]{i , j}) ;
            }
        }

        if(freshCount == 0) return 0 ;

        int minutes = 0 ;
        while(queue.size() > 0){
            int s = queue.size() ;
            for(int cnt = s ; cnt > 0 ; cnt--){
                int[] curr = queue.remove() ;
                int i = curr[0] ;
                int j = curr[1] ;

                // i+1 , j
                if(i + 1 < m && grid[i + 1][j] == 1){
                    grid[i + 1][j] = 2 ;
                    freshCount-- ;
                    queue.add(new int[]{i + 1 , j}) ;
                }

                // i-1 , j
                if(i - 1 >= 0 && grid[i - 1][j] == 1){
                    grid[i - 1][j] = 2 ;
                    freshCount-- ;
                    queue.add(new int[]{i - 1 , j}) ;
                }

                // i , j+1
                if(j + 1 < n && grid[i][j + 1] == 1){
                    grid[i][j+1] = 2 ;
                    freshCount-- ;
                    queue.add(new int[]{i , j + 1}) ;
                }

                // i , j-1
                if(j - 1 >= 0 && grid[i][j - 1] == 1){
                    grid[i][j - 1] = 2 ;
                    freshCount-- ;
                    queue.add(new int[]{i , j - 1}) ;
                }

            }
            minutes++ ;
        }

        if(freshCount == 0) return minutes - 1 ;
        return -1 ;
    }
}