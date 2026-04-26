class Solution {
    public boolean containsCycle(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] vis = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!vis[i][j]) {
                    if (bfs(grid, i, j, vis)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean bfs(char[][] grid, int i, int j, boolean[][] vis) {
        Queue<int[]> q = new LinkedList<>();
        int dx[] = { 0, 1, -1, 0 };
        int dy[] = { 1, 0, 0, -1 };

        q.add(new int[] { i, j, -1, -1 });
        vis[i][j] = true;

        while (!q.isEmpty()) {
            int arr[] = q.poll();
            int x = arr[0], y = arr[1], px = arr[2], py = arr[3];
            for(int k = 0;k<4;k++){
                int newx = x + dx[k];
                int newy = y + dy[k];

                if(newx >= 0 && newx < grid.length && newy >= 0 && newy <grid[0].length){
                   if (grid[newx][newy] != grid[x][y]) continue;
                    if(!vis[newx][newy]){
                        q.add(new int[]{newx,newy,x,y});
                        vis[newx][newy] = true;
                    }else{
                        if(newx !=px || newy != py){
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
}