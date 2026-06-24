class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        int n = groupSizes.length;
        List<List<Integer>> ans = new ArrayList<>();
        HashMap<Integer,List<Integer>> map = new HashMap<>();
        for(int i = 0;i<n;i++){
            int size = groupSizes[i];

            map.putIfAbsent(size,new ArrayList<>());
            map.get(size).add(i);

            if(map.get(size).size() == size){
                ans.add(new ArrayList<>(map.get(size)));
                map.get(size).clear();
            }
        }
        
        return ans;

    }
}