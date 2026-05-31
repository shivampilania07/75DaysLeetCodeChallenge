class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int V =numCourses;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i =0;i<V;i++){
            adj.add(new ArrayList<>());
        }

        
         for(int[] v : prerequisites){
                adj.get(v[0]).add(v[1]);
            }
        

        boolean[] vis = new boolean[V];
        boolean[] inRecursion = new boolean[V];

        for(int i = 0;i<V;i++){
            if(vis[i] == false && isCycleDFS(adj,i,vis,inRecursion)){
                return false;
            }
        }
        return true;
    }

    public boolean isCycleDFS(ArrayList<ArrayList<Integer>> adj,int curr,boolean[] vis,boolean[] inRecursion){
        vis[curr] = true;
        inRecursion[curr] = true;

        for(int v : adj.get(curr)){
            if(vis[v] == false && isCycleDFS(adj,v,vis,inRecursion)){
                return true;
            }else if(inRecursion[v] == true){
                return true;
            }
        }

        inRecursion[curr] = false;
        return false;
    }
}