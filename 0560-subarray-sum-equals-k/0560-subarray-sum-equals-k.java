class Solution {
    public int subarraySum(int[] nums, int k) {
        int count = 0, sum = 0;
        int n = nums.length;
        HashMap<Integer, Integer> sumFreq = new HashMap<>();
        sumFreq.put(0, 1);
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            int rem = sum - k;
            count += sumFreq.getOrDefault(rem, 0);
            sumFreq.put(sum, sumFreq.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}