class Solution {
    int n;
    int[] dp;
    public int minCostClimbingStairs(int[] cost) {
        n = cost.length;
        dp = new int[n];
        Arrays.fill(dp,-1);
        int min = Integer.MAX_VALUE;
        min=Math.min(min,check(cost,0));
        min = Math.min(min,check(cost,1));

        return min;
    }
    public int check(int[] cost, int start){
        if(start >= n){
            return 0;
        }

        if(dp[start]!=-1) return dp[start];
        
        int onestep = check(cost,start+1);
         
         int twostep = check(cost,start+2);

        return dp[start] = cost[start] + Math.min(onestep,twostep);

    }
}