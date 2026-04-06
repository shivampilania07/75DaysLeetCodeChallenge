class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int V = numCourses;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] v : prerequisites) {
            adj.get(v[1]).add(v[0]); //reverse the graph..
        }

        int[] indegree = new int[V];
        for (int u = 0; u < V; u++) {
            for (int v : adj.get(u)) {
                indegree[v]++;
            }
        }

        return topologicalSort(adj,V,indegree);

    }

    public int[] topologicalSort(ArrayList<ArrayList<Integer>> adj,int V,int[] indegree){
        Queue<Integer> queue = new LinkedList<>();
        ArrayList<Integer> ans = new ArrayList<>();
        int count = 0;
        for(int i =0 ;i<V;i++){
             if(indegree[i] == 0){
                count++;
                ans.add(i);
                queue.add(i); 
             }
        }

        while(!queue.isEmpty()){
            int u = queue.poll();
            for(int v : adj.get(u)){
                indegree[v]--;
                if(indegree[v] == 0){
                    count++;
                    ans.add(v);
                    queue.add(v);
                }
            }
        }
        if(count == V){
            int[] temp = new int[ans.size()];
            for(int i = 0;i<ans.size();i++){
                temp[i] = ans.get(i);
            }
            return temp;
        }

        return new int[]{};
    }
}