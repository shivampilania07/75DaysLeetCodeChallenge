class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        int i = 0;
        int j = n-1;
        int ans = Integer.MIN_VALUE;
        while(i<j){
            int water_height = Math.min(height[i],height[j]);
            int width = Math.abs(i-j);
            int area = water_height * width;
            if(height[i]<height[j]){
                i++;
            }else{
                j--;
            }
            ans = Math.max(ans,area);

        }
        return ans;
    }
}