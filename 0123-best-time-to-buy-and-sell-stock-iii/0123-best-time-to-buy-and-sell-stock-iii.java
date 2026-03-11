class Solution {
    // public int solve(int idx,int buy,int cap, int[] prices,int n,int[][][] dp){
    //     if(idx == n || cap == 0) return 0;

    //     if( dp[idx][buy][cap] != -1) return  dp[idx][buy][cap];

    // if(buy == 1){
    //     dp[idx][buy][cap] = Math.max(-prices[idx] + solve(idx+1,0,cap,prices,n,dp), solve(idx+1,1,cap,prices,n,dp));
    // }else{
    //      dp[idx][buy][cap] = Math.max(prices[idx] + solve(idx+1,1,cap-1,prices,n,dp),solve(idx+1,0,cap,prices,n,dp));
    // }

    //     return  dp[idx][buy][cap];
    // }
    public int maxProfit(int[] prices) {

        int n = prices.length;
        int[][][] dp = new int[n + 1][2][3];
        // for(int i = 0;i<n;i++){
        //     for(int j=0;j<2;j++){
        //         Arrays.fill(dp[i][j],-1);
        //     }
        // }

        // return solve(0,1,2,prices,n,dp);

        //bottom up

        //base case
         


        for (int idx = n - 1; idx >= 0; idx--) {
            for (int buy = 0; buy < 2; buy++) {
                for (int cap = 1; cap <= 2; cap++) {
                    if (buy == 1) {
                        dp[idx][buy][cap] = Math.max(-prices[idx] + dp[idx + 1][0][cap],
                                dp[idx+1][1][cap]);
                    } else {
                        dp[idx][buy][cap] = Math.max(prices[idx] + dp[idx + 1][1][cap - 1],
                                dp[idx + 1][ 0][cap]);
                    }
                }
            }
        }
        return dp[0][1][2];
    }
}