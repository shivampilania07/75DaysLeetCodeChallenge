class Solution {
    public int minimumDistance(int[] nums) {
        int n = nums.length;
        int min = Integer.MAX_VALUE;
        int res = -1;
        for(int i = 0;i<n;i++){
            for(int j=i+1;j<n;j++){
                for(int k=j+1;k<n;k++){
                    if(nums[i] == nums[j] && nums[j] == nums[k]){
                        min = Math.min(min,Math.abs(i-j)+Math.abs(j-k)+Math.abs(k-i));
                        res = min;
                    }
                    
                }
            }
        }
        return res;
    }
}