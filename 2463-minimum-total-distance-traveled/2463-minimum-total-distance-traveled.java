class Solution {
    public long minimumTotalDistance(List<Integer> robot, int[][] factory) {
        //Step-1
        Collections.sort(robot);
        Arrays.sort(factory,Comparator.comparingInt(a -> a[0])); //2d array sorting
        int m = robot.size();

        //Step-2(expand the factory positons)
        List<Integer> positions = new ArrayList<>();
        for(int[] f : factory){
            int pos = f[0];
            int limit = f[1];

            for(int j =0;j<limit;j++){
                positions.add(pos);
            }
        }

        int n = positions.size();
        long[][] dp = new long[m+1][n+1];
        for(long[] row : dp) Arrays.fill(row,-1);


        return solve(0,0,robot,positions,dp);
    }

    public long solve(int ri ,int fi,List<Integer> robot,List<Integer> positions,long[][] dp){
        if(ri >= robot.size()) return 0;

        if(fi >= positions.size())  return (long)1e18;;

        if(dp[ri][fi] != -1) return dp[ri][fi] ;

        long takeCurrentFactory = Math.abs(robot.get(ri) - positions.get(fi)) + solve(ri+1,fi+1,robot,positions,dp);
        long skip = solve(ri,fi+1,robot,positions,dp);

        return dp[ri][fi] = Math.min(takeCurrentFactory,skip);
    }
}