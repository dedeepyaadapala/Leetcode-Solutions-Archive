class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int val = image[sr][sc];
        int m = image.length;
        int n = image[0].length;
        int[][] dist = new int[][]{{-1,0},{1,0},{0,1},{0,-1}};
        boolean[][] vis = new boolean[m][n];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{sr,sc});
        image[sr][sc] = color;
        vis[sr][sc] = true;
        while(!q.isEmpty()){
            int[] curr = q.poll();
            for(int[] ij : dist){
                int ni = curr[0] + ij[0];
                int nj = curr[1] + ij[1];
                if(ni >= 0 && ni < m && nj >= 0 && nj < n &&!vis[ni][nj] && image[ni][nj] == val){
                    q.add(new int[]{ni,nj});
                    image[ni][nj] = color;
                    vis[ni][nj] = true;
                }
            }
        }
        return image;
    }
}