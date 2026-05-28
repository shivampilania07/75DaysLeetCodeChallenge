class Solution {
    int m;
    int n;
    int[][] dir = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

    public int numIslands(char[][] grid) {
        m = grid.length;
        n = grid[0].length;

        boolean[][] visited = new boolean[m][n];
        int count = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    bfs(grid, i, j, visited);
                    count++;
                }
            }
        }
        return count;
    }

    public void bfs(char[][] grid, int i, int j, boolean[][] visited) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{i,j});
        visited[i][j] = true;

        while(!queue.isEmpty()){
            int[] curr = queue.poll();
            int row = curr[0];
            int col = curr[1];

            for(int k = 0;k<4;k++){
                int newi = row + dir[k][0];
                int newj = col + dir[k][1];

                if(newi>=0 && newi<m && newj>=0 && newj < n && grid[newi][newj] == '1' && !visited[newi][newj]){
                    visited[newi][newj] = true;
                    queue.offer(new int[]{newi,newj});
                }
            }
        }
    }
}