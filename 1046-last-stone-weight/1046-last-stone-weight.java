class Solution {
    public int lastStoneWeight(int[] stones) {
        int n = stones.length;
        PriorityQueue<Integer> pq =
            new PriorityQueue<>(Collections.reverseOrder());
        for(int stone : stones){
            pq.add(stone);
        }
        int ans = 0;
        int size = pq.size();
        if(size == 1){
            return pq.poll();
        }
        while(pq.size()>1){
            int first = pq.poll();
            int second = pq.poll();

             if(first != second){
                pq.add(first-second);
            }
        }
       return pq.isEmpty() ? 0 : pq.poll();
    }
}