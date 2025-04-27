class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        for(int i = n-2;i >= 0;i--){
            matrix[i][0] += Math.min(matrix[i+1][0],matrix[i+1][1]);
            matrix[i][n-1] += Math.min(matrix[i+1][n-1],matrix[i+1][n-2]);
            for(int j = 1;j < n-1;j++){
                matrix[i][j] += Math.min(matrix[i+1][j],Math.min(matrix[i+1][j-1],matrix[i+1][j+1]));
            }
        }
        int ans = Integer.MAX_VALUE;
        for(int i = 0;i < n;i++){
            ans = Math.min(ans,matrix[0][i]);
        }
        return ans;
    }
}