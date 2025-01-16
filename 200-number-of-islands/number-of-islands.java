class Solution {
    public int numIslands(char[][] grid) {
        int count = 0 ;
        for(int i = 0 ; i < grid.length ; i++){
            for(int j = 0 ; j < grid[0].length ; j++){
                Character ch = grid[i][j] ;
                if(ch.equals('1')){
                    count++ ;
                    DFS(grid , i , j) ;
                }
            }
        }
        return count ;
    }

    public void DFS(char[][] grid , int i , int j){
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length ){
            return ;
        }

        Character ch = grid[i][j] ;
        if(ch.equals('0')){
            return ;
        }
        
        grid[i][j] = '0' ;

        DFS(grid , i , j + 1) ;
        DFS(grid , i , j - 1) ;
        DFS(grid , i + 1 , j) ;
        DFS(grid , i - 1 , j) ;
    }
}