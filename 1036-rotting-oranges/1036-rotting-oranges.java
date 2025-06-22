class Solution {
    static int[][] dij = new int[][]{{0,-1},{-1,0},{0,1},{1,0}};
    public int orangesRotting(int[][] grid) {
        int m = grid.length,n = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        for(int i = 0;i < m;i++){
            for(int j = 0;j < n;j++){
                if(grid[i][j] == 2){
                    grid[i][j] = 0;
                    q.add(new int[]{i,j});
                }
            }
        }
        int cnt = 0;
        while(!q.isEmpty()){
            int x = q.size();
            cnt++;
            for(int i = 0;i < x;i++){
                int[] curr = q.poll();
                    for(int[] ij : dij){
                        int ni = curr[0] + ij[0];
                        int nj = curr[1] + ij[1];
                        if(ni >= 0 && ni < m && nj >= 0 && nj < n && grid[ni][nj] != 0){
                            q.add(new int[]{ni,nj});
                            grid[ni][nj] = 0;
                        }
                    }
            }
        }
        for(int i = 0;i < m;i++){
            for(int j = 0;j < n;j++){
                if(grid[i][j] != 0) return -1;
            }
        }
        return cnt== 0 ? 0 : cnt-1;
    }
}