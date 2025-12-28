class Solution {
    public int countNegatives(int[][] grid) {
        int count = 0,m = grid.length,n=grid[0].length;
        for(int i = 0; i< m;i++){
            int j = n-1;
            while(j >= 0 && grid[i][j] < 0){
                j--;
            }
            count += n-j-1;
        }
        return count;
    }
}