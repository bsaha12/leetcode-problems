class Solution {
    public int numEnclaves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        UnionFind uf = new UnionFind(grid);

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int index = i * n + j;
                if (grid[i][j] == 1) {
                    if (i < m - 1 && grid[i + 1][j] == 1) {
                        uf.union(index, index + n);
                    }

                    if (j < n - 1 && grid[i][j + 1] == 1) {
                        uf.union(index, index + 1);
                    }

                }
            }
        }

        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int index = i * n + j;
                if (grid[i][j] == 1 && !uf.isOnEdge(index)) {
                    count++;
                }
            }
        }

        return count;
    }
}

class UnionFind {

    private boolean isEdge[];
    private int[] parent, size;

    public UnionFind(int[][] grid){
        int m = grid.length ;
        int n = grid[0].length ;
        parent = new int[m * n] ;
        size = new int[m * n] ;
        isEdge = new boolean[m* n] ;
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                int index = i * n + j ;
                if(i == 0 || j == 0 || i == m - 1 || j == n-1 ){
                    isEdge[index] = true ;
                }
                parent[index] = index ;
                size[index] = 1 ;
            }
        }
    }

    public void union(int x, int y) {
        int rpsX = find(x);
        int rpsY = find(y);

        if (rpsX == rpsY) {
            return;
        }

        if (size[rpsX] > size[rpsY]) {
            size[rpsX] += size[rpsY];
            parent[rpsY] = rpsX;
        } else {
            size[rpsY] += size[rpsX];
            parent[rpsX] = rpsY;
        }

        isEdge[rpsX] = isEdge[rpsX] || isEdge[rpsY];
        isEdge[rpsY] = isEdge[rpsY] || isEdge[rpsX];
    }

    public int find(int x) {
        if (x != parent[x]) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    public boolean isOnEdge(int x) {
        int rpsX = find(x);
        return isEdge[rpsX];
    }
}