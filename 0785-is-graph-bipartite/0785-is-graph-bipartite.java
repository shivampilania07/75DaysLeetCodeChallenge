class Solution {
    public boolean isBipartite(int[][] graph) {
        int m = graph.length;
        int n = graph[0].length;

        int[] color = new int[m];
        Arrays.fill(color,-1);

        ArrayList<ArrayList<Integer>> adjlist = new ArrayList<>();

       for(int i = 0; i < m; i++){
    adjlist.add(new ArrayList<>());
}

for(int i = 0; i < m; i++){
    for(int j = 0; j < graph[i].length; j++){
        adjlist.get(i).add(graph[i][j]);
    }
}

        for(int i = 0;i<m;i++){
            if(color[i] == -1){
                if(bfs(adjlist,i,color,1)==false) return false;
            }
        }

        return true;
    }

    public boolean bfs(ArrayList<ArrayList<Integer>> adjlist,int curr,int[] color,int currColor){
        Queue<Integer> que = new LinkedList<>();
        que.add(curr);
        color[curr] = currColor;
        while(!que.isEmpty()){
            int u = que.poll();
            for(int v : adjlist.get(u)){
                if(color[v] == color[u]) return false;
                else if(color[v] == -1){
                    color[v] = 1 - color[u];
                    que.add(v);
                }
            }
        }
        return true;
    }

    
}