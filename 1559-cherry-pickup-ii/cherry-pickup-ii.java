class Solution {
    int[][] grid ;
    int row , col ;
    int[][][] cache ;
    public int cherryPickup(int[][] grid) {
        this.grid = grid ;
        row = grid.length ;
        col = grid[0].length ;
        cache = new int[ row + 1][col + 1][col + 1] ;
        for(int[][] arr : cache){
            for(int[] temp : arr){
                Arrays.fill(temp , -1) ;
            }
        }
        return helper(0 , col - 1  , 0) ;
    }

    public int helper(int x , int col1 , int col2){
        // base condition
        if( x >= row) return 0 ;

        if(cache[x][col1][col2] != -1) return cache[x][col1][col2] ;

        int curr = grid[x][col1] ;
        if(col1 != col2){
            curr += grid[x][col2] ;
        }

        int next = 0 ;
        // next x is x + 1 
        // find all possible cols which can be traversed

        // right movement for robot 1
        if(col1 + 1 < col){
            next = Math.max(next , helper(x + 1 , col1 + 1 , col2) );
            if(col2 + 1 < col)
                next = Math.max(next , helper(x + 1 , col1 + 1 , col2 + 1));
            if(col2 - 1 >= 0)
                next = Math.max(next , helper(x + 1 , col1 + 1 , col2 - 1));
        }

        // right movement for robot 2
        if(col2 + 1 < col){
            next = Math.max(next , helper(x + 1 , col1 , col2 + 1) );
            if( col1 - 1 >= 0)
                next = Math.max(next , helper(x + 1 , col1 - 1 , col2 + 1));
        }

        if(col1 - 1 >= 0){
            next = Math.max(next , helper(x + 1 , col1 - 1 , col2));
            if(col2 - 1 >= 0){
                next = Math.max(next , helper(x + 1 , col1 - 1 , col2 - 1)) ;
            }
        }

        if(col2 -1 >= 0){
            next = Math.max(next , helper(x + 1 , col1 , col2 - 1) ) ;
        }

        next = Math.max(next , helper( x + 1 , col1 , col2)) ;

        // if( x == 2){
        //     System.out.println("----Row : " + x + " --------" );
        //     System.out.println("Col1 : " + col1 +  " , Col2 : " + col2) ;
        //     System.out.println("Next : " + next + " , Curr : " + curr) ;
        //     System.out.println("-----------") ;
        // }
        
        return cache[x][col1][col2] = next + curr ;
    }
}