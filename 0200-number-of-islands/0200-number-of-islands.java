class Solution {
    private static int[][] dij = new int[][]{{-1,0},{1,0},{0,-1},{0,1}};
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int cnt = 0;
        boolean[][] vis  = new boolean[m][n];
        for(int i = 0;i < m;i++){
            for(int j = 0;j < n;j++){
                if(!vis[i][j] && grid[i][j] == '1'){
                    bfs(grid,vis,m,n,i,j);
                    cnt++;
                }
            }
        }
        return cnt;
    }

    private static void bfs(char[][] grid, boolean[][] vis, int m, int n, int i,int j){
        Queue<int[]> q = new LinkedList<>();
        vis[i][j] = true;
        q.add(new int[]{i,j});
        while(!q.isEmpty()){
            int[] curr = q.poll();
            for(int[] ij : dij){
                int ni = curr[0] + ij[0];
                int nj = curr[1] + ij[1];
                if(ni >= 0 && ni < m && nj >= 0 && nj < n && !vis[ni][nj] && grid[ni][nj] == '1'){
                    q.add(new int[]{ni,nj});
                    vis[ni][nj] = true;
                }
            }
        }
    }
}