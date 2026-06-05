class Solution {
    int n;
    public int rob(int[] nums) {
        n = nums.length;
        if(n==1) return nums[0];
        int[] dp1 = new int[n];
        Arrays.fill(dp1,-1);
        int firstway = solve(nums,0,n-2,dp1);
        int[] dp2 = new int[n];
        Arrays.fill(dp2,-1);
        int secondway = solve(nums,1,n-1,dp2);

        return Math.max(firstway,secondway);
    }
    public int solve(int[] nums,int i,int n,int[] dp){
        if(i>n) return 0;

        if(dp[i] != -1) return dp[i];

        int rob = nums[i] + solve(nums,i+2,n,dp);
        int notrob = solve(nums,i+1,n,dp);

        return dp[i] = Math.max(rob,notrob);
    }
}