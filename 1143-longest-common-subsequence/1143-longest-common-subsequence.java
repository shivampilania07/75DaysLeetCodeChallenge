class Solution {
    public int solve(String text1,String text2,int i,int j,int[][] dp){
        int m = text1.length();
        int n = text2.length();

        if(i == m || j == n) return 0;

        if(dp[i][j] != -1) return dp[i][j];

        if(text1.charAt(i) == text2.charAt(j)){
            dp[i][j] =  1 + solve(text1,text2,i+1,j+1,dp);
        }else{
            dp[i][j] =  Math.max(solve(text1,text2,i+1,j,dp),solve(text1,text2,i,j+1,dp));
        }
        return dp[i][j];
    }
    public int longestCommonSubsequence(String text1, String text2) {

        int[][] dp = new int[1001][1001];
        for(int[] row : dp) Arrays.fill(row,-1);

        return solve(text1,text2,0,0,dp);
    }
}