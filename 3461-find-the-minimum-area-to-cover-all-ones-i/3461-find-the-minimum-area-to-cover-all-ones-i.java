class Solution {
    public int minimumArea(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int startRow = -1, endRow = -1;
        int startCol = n, endCol = -1;
        for(int i = 0;i < m;i++){
            for(int j = 0;j < n;j++){
                if(grid[i][j] == 1){
                    if(startRow == -1) startRow = i;
                    endRow = i;
                    startCol = Math.min(startCol,j);
                    endCol = Math.max(endCol,j);
                }
            }
        }
        return (endRow - startRow + 1) * (endCol - startCol + 1);
    }
}