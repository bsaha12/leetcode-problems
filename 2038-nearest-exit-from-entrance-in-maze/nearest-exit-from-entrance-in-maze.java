class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        Queue<int[]> queue = new LinkedList<>() ;
        queue.add(entrance) ;
        int steps = 0 ;
        while(!queue.isEmpty()){
            int size = queue.size() ;
            for(int i = 0 ; i < size ; i++){
                int[] currPos = queue.poll() ;
                int currX = currPos[0] ;
                int currY = currPos[1] ;

                // update the current position to wall
                maze[currX][currY] = '+' ;

                // if the current position is edge then return steps covered ;
                if(isEdge(maze , currX , currY) & steps != 0) return steps ;

                if(isEmptyAndValidCell(maze, currX + 1, currY )) queue.offer(new int[]{currX + 1 ,currY}) ;
                if(isEmptyAndValidCell(maze, currX, currY + 1 )) queue.offer(new int[]{currX, currY + 1}) ;
                if(isEmptyAndValidCell(maze, currX - 1, currY )) queue.offer(new int[]{currX - 1, currY}) ;
                if(isEmptyAndValidCell(maze, currX, currY - 1 )) queue.offer(new int[]{currX, currY - 1}) ;
            }
            steps++ ;
        }

        return -1 ;
    }

    public boolean isEdge(char[][] maze , int x , int y ){
        int m = maze.length ;
        int n = maze[0].length ;

        if(x == 0 || y == 0 || x == m - 1 || y == n - 1) return true;

        return false ;
    }

    public boolean isEmptyAndValidCell(char[][] maze , int x , int y){
        int m = maze.length ;
        int n = maze[0].length ;

        if(x < 0 || y < 0 || x >= m || y >= n) return false ;

        if(maze[x][y] == '.') {
            maze[x][y] = '+' ;
            return true ;
        }

        return false ;
    }
}