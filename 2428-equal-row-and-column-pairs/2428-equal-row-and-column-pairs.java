class Solution {
    public int equalPairs(int[][] grid) {
        int n = grid.length;
        int[][] trans = new int[n][n];
        for(int i = 0;i < n;i++){
            for(int j = 0;j < n;j++){
                trans[i][j] = grid[j][i];
            }
        }
        int cnt = 0;
        for(int i = 0;i < n;i++){
            for(int j = 0;j < n;j++){
                boolean flag = true;
                for(int l = 0;l < n;l++){
                    if(grid[i][l] != trans[j][l]){
                        flag = false;
                        break;
                    }
                }
                if(flag) cnt++;
            }
        }
        return cnt;
    }
}