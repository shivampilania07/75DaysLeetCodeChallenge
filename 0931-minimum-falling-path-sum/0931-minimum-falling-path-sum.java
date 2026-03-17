class Solution {
    // public int solve(int[][] matrix,int row,int col,int[][] dp){
    //     int m = matrix.length;
    //     int n = matrix[0].length;

    //     //if(col >= n || col < 0) return Integer.MAX_VALUE; //boundary conditon occurs

    //     if(row == m-1) return matrix[row][col]; //Reached final cell 

    //     if(dp[row][col] != -1) return dp[row][col];

    //     int ans = matrix[row][col];
    //     int minSum = Integer.MAX_VALUE;

    //     // if(row+1<m && col-1>=0)
    //     // minSum = Math.min(minSum,ans + solve(matrix,row+1,col-1,dp));
    //     // if(row+1<m)
    //     // minSum = Math.min(minSum,ans+ solve(matrix,row+1,col,dp));
    //     // if(row+1<m && col+1 < n )
    //     // minSum=Math.min(minSum,ans + solve(matrix,row+1,col+1,dp));

    //     for(int shift = -1;shift<=1;shift++){
    //         if(row+1<m && col + shift < n && col + shift >= 0){
    //             minSum = Math.min(minSum,ans+solve(matrix,row+1,col+shift,dp));
    //         }
    //     }

    //      return dp[row][col] = minSum;
    // }
    public int minFallingPathSum(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int[][] dp = new int[m][n];
        for (int col = 0; col < n; col++) {
            dp[0][col] = matrix[0][col];
        }

        for (int row = 1; row < m; row++) {
            for(int col = 0;col<n;col++){
                int first = Integer.MAX_VALUE;
                int second = Integer.MAX_VALUE;
                int third = Integer.MAX_VALUE;
                if(row-1>=0){
                     first = dp[row-1][col];
                }
                if(col-1>=0 && row-1>=0){
                     second = dp[row-1][col-1];
                }
                if(row-1>=0 && col+1 <n ){
                     third = dp[row-1][col+1];
                }
                dp[row][col] = matrix[row][col] + Math.min(first,Math.min(second,third));
            }
        }

        //find minimum from last row
        int result = Integer.MAX_VALUE;
        int lastRow = m-1;

        for(int col = 0;col<n;col++){
            result = Math.min(result,dp[lastRow][col]);
        }

        return result;
    }
}