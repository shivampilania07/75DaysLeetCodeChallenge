class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int n = image.length;
        int m = image[0].length;

        int org = image[sr][sc];
        if(org == color) return image;

        dfs(sr,sc,org,color,image,n,m);

        return image;

    }

    public void dfs(int sr,int sc,int org,int color,int[][] image,int n,int m){
        image[sr][sc] = color;
        int[][] dir = {{-1,0},{1,0},{0,1},{0,-1}};

        for(int k = 0;k<4;k++){
            int newr = sr + dir[k][0];
            int newc = sc + dir[k][1];

            if(newr>=0 && newr<n && newc>=0 && newc<m && image[newr][newc]==org){
                dfs(newr,newc,org,color,image,n,m);
            }
        }
    }
}