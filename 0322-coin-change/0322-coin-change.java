class Solution {
    int n;
    int[][] dp;
    public int coinChange(int[] coins, int amount) {
        n = coins.length;
        if (amount < 1)
            return 0;
        dp = new int[n][amount+1];
        for(int[] rows : dp) Arrays.fill(rows,-1);

        int total = Integer.MAX_VALUE;
        total = solve(coins, amount, 0);
        return total == Integer.MAX_VALUE ? -1 : total;
    }

    public int solve(int[] coins, int amount, int i) {
        if(amount == 0) return 0;
        if(i == n || amount < 0) return Integer.MAX_VALUE;

        if(dp[i][amount] != -1) return dp[i][amount];

        int take = solve(coins,amount-coins[i],i);
        if(take != Integer.MAX_VALUE){
            take = take +1;
        }
        int skip = solve(coins,amount,i+1);
        return dp[i][amount] = Math.min(take,skip);
    }
}