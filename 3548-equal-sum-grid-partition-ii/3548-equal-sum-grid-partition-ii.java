class Solution {
    public boolean canPartitionGrid(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;

        long totalSum = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                totalSum += grid[i][j];
            }
        }

        if (checkHorCut(grid, totalSum)) {
            return true;
        }

        reverse(grid);

        if (checkHorCut(grid, totalSum)) {
            return true;
        }

        reverse(grid);

        int[][] trans = new int[col][row];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                trans[j][i] = grid[i][j];
            }
        }

        if (checkHorCut(trans, totalSum)) {
            return true;
        }

        reverse(trans);

        return (checkHorCut(trans, totalSum));
         
    }

    public boolean checkHorCut(int[][] grid, long totalSum) {
        int m = grid.length;
        int n = grid[0].length;
        long top = 0;
        HashSet<Long> set = new HashSet<>();
        for (int i = 0; i <= m - 2; i++) {
            for (int j = 0; j < n; j++) {
                set.add((long)grid[i][j]);
                top += grid[i][j];
            }
            long bottom = (totalSum - top);
            long diff = (top - bottom);

            if (diff == 0)
                return true;
            if (diff == grid[0][0])
                return true;
            if (diff == grid[0][n - 1])
                return true;
            if (diff == grid[i][0])
                return true;
            if (i > 0 && n > 1 && set.contains(diff))
                return true;
        }
        return false;

    }

    private void reverse(int[][] grid) {
        int top = 0, bottom = grid.length - 1;

        while (top < bottom) {
            int[] temp = grid[top];
            grid[top] = grid[bottom];
            grid[bottom] = temp;

            top++;
            bottom--;
        }
    }

}