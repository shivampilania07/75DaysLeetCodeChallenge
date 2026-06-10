class Solution {
    public int[][] merge(int[][] intervals) {
        int m = intervals.length;
        int n = intervals[0].length;
        List<int[]> list = new ArrayList<>();

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        list.add(intervals[0]);

        for (int i = 1; i < m; i++) {
            int[] prev = list.get(list.size() - 1);
            int s = intervals[i][0];
            int e = intervals[i][1];

            //merge condition
            if(s<=prev[1]){
                //merge them
                prev[0] = Math.min(prev[0],s);
                prev[1] = Math.max(prev[1],e);
            }else{
                list.add(intervals[i]);
            }
        }

        int[][] res = new int[list.size()][2];
        for(int i = 0;i<list.size();i++){
            res[i] = list.get(i);
        }
        return res;
    }
}