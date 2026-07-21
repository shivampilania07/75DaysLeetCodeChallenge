class Solution {
    int[] dp;
    public boolean wordBreak(String s, List<String> wordDict) {
        dp = new int[s.length()+1];
        Arrays.fill(dp,-1);
        return solve(0,s,wordDict);
    }

    public boolean solve(int idx,String s,List<String> wordDict){
        if(idx == s.length()){
            return true;
        }
        if(dp[idx]!=-1){
            return dp[idx] == 1;
        }
        // if(wordDict.contains(s)){
        //     return true;
        // }

        for(int i = idx+1;i<=s.length();i++){
            String temp = s.substring(idx,i);

            if(wordDict.contains(temp) && solve(i,s,wordDict)){
                dp[idx] = 1;
                return true;
            }
        }
        dp[idx] = 0;
        return false;
    }
}