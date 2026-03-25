class Solution {
    public int maxProfit(int[] prices) {
        int mine = prices[0];
        int max = Integer.MIN_VALUE;
        if(prices.length == 1) return 0;
        for(int i = 1;i<prices.length;i++){
            mine = Math.min(mine,prices[i]);
            int diff = prices[i] - mine;
            max = Math.max(max,diff);
        }

        return max;

    }
}