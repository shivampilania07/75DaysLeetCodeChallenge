class Solution {
    public boolean canPartitionGrid(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;

        long sum= 0;

        for(int i = 0;i<row;i++){
            for(int j =0;j<col;j++){
                sum+=grid[i][j];
            }
        }

        if(sum%2!=0) return false;

        long sum1 = 0;
        for(int i =0;i<row-1;i++){
            for(int j =0;j<col;j++){
                sum1+=grid[i][j];
            }
            if(sum1*2==sum) return true;
        }

        sum1= 0;
        for(int j =0;j<col-1;j++){
            for(int i =0;i<row;i++){
                sum1+=grid[i][j];
            }
            if(sum1*2==sum) return true;
        }

        return false;
        
    }
}