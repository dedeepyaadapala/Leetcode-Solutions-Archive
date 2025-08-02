class Solution {
    static int cnt = 0;
    public int numEnclaves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        cnt = 0;
        for(int i = 0;i < m;i++){
            for(int j = 0;j < n;j++){
                cnt += (grid[i][j] == 1 ? 1 : 0);
            }
        }

        for(int i = 0;i < m;i++){
            if(grid[i][0] == 1){
                dfs(grid,m,n,i,0);
            }
            if(grid[i][n-1] == 1){
                dfs(grid,m,n,i,n-1);
            }
        }

        for(int j = 0;j < n;j++){
            if(grid[0][j] == 1){
                dfs(grid,m,n,0,j);
            }
            if(grid[m-1][j] == 1){
                dfs(grid,m,n,m-1,j);
            }
        }

        return cnt;
    }


    private static void dfs(int[][] grid,int m,int n,int i,int j){
        if(i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == 0) return;
        if(grid[i][j] == 1){
            cnt--;
            grid[i][j] = 0;
            dfs(grid,m,n,i+1,j);
            dfs(grid,m,n,i-1,j);
            dfs(grid,m,n,i,j-1);
            dfs(grid,m,n,i,j+1);
        }
    }
}