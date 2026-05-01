class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        //Arrays.sort(nums);
        int count = 0;
        // int[] prefix = new int[n];
        // prefix[0] = nums[0];

        // for (int i = 1; i < n; i++) {
        //     prefix[i] = nums[i] + prefix[i - 1];
        // }

        for(int i = 0;i<n;i++){
            int sum = 0;
            for(int j = i;j<n;j++){
                sum+=nums[j];
                if(sum == k){
                    count++;
                }
            }
        }

        return count;
    }
}