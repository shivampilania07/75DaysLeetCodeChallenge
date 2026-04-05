class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int m = graph.length;
        int n = graph[0].length;

        boolean[] vis = new boolean[m];
        boolean[] inRecursion = new boolean[m];

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for(int i = 0; i < m; i++){
            adj.add(new ArrayList<>());
            for(int j : graph[i]){
                adj.get(i).add(j);
            }
        }

        ArrayList<Integer> ans = new ArrayList<>();

        for(int i = 0;i<m;i++){
            if(vis[i] == false)
            isCycleDFS(adj,i,vis,inRecursion);
        }

        for(int i = 0;i<m;i++){
            if(inRecursion[i] == false){
                ans.add(i);
            }
        }
        return ans;
    }

    public boolean isCycleDFS(ArrayList<ArrayList<Integer>> adj,int curr,boolean[] vis,boolean[] inRecursion){
        vis[curr] = true;
        inRecursion[curr] = true;

        for(int i : adj.get(curr)){
            if(vis[i] == false && isCycleDFS(adj,i,vis,inRecursion)){
                return true;
            }else if(inRecursion[i] == true){
                return true;
            }
        }
        
        inRecursion[curr] = false;
        return false;
    }
}