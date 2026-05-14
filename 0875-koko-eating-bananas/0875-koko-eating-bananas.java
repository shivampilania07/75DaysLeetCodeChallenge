class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;
        int left = 1;
        int right = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            right = Math.max(right, piles[i]);
        }
        int ans = right;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (isPossible(piles, h, mid)) {
                ans = mid;
                right = mid-1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }

    public boolean isPossible(int[] piles, int h, int mid) {
        long hours = 0;
        for(int pile : piles){
            hours+=(pile+mid-1)/mid;
            if(hours>h){
                return false;
            }
        }
        return true;
    }
}