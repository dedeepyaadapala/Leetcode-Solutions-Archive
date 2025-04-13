class Solution {
    public int uniquePathsWithObstacles(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] paths = new int[m][n];
        for(int i = 0;i < m;i++){
            if(grid[i][0] == 1){
                break;
            }
            paths[i][0] = 1;
        }
        for(int i = 0;i < n;i++){
            if(grid[0][i] == 1){
                break;
            }
            paths[0][i] = 1;
        }
        for(int i = 1;i < m;i++){
            for(int j = 1;j < n;j++){
                if(grid[i][j] != 1){
                    paths[i][j] = paths[i-1][j] + paths[i][j-1];
                }
            }
        }
        return paths[m-1][n-1];
    }
}