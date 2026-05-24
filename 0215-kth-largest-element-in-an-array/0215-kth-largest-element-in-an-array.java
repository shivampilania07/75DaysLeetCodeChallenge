class Solution {
    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
       

        for(int x : nums){
            pq.offer(x);
        }

        while(k-->1){
            pq.poll();
        }
        return pq.poll();
    }
}