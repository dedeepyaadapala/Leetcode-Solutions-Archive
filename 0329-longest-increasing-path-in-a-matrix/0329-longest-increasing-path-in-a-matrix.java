class Solution {
    private static int directions[][] = new int[][]{{-1,0},{1,0},{0,-1},{0,1}};
    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        for(int i = 0;i < m;i++) Arrays.fill(dp[i],-1);
        for(int i = 0;i < m;i++){
            for(int j = 0;j < n;j++){
                if(dp[i][j] == -1) dfs(matrix,m,n,dp,i,j);
            }
        }
        int ans = 0;
        for(int i = 0;i < m;i++){
            for(int j = 0;j < n;j++){
                // System.out.print(dp[i][j]+" ");
                ans = Math.max(ans,dp[i][j]);
            }
            // System.out.println();
        }
        return ans;
    }

    private static int dfs(int[][] mat,int m,int n,int[][] dp,int i,int j){
        if(i < 0 || i >= m || j < 0 || j >= n) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        dp[i][j] = 1;
        for(int[] dir : directions){
            int ni = i + dir[0];
            int nj = j + dir[1];
            if(inBounds(ni,nj,m,n) && mat[ni][nj] > mat[i][j]){
                dp[i][j] = Math.max(dp[i][j],1+dfs(mat,m,n,dp,ni,nj));
            }
        }
        return dp[i][j];
    }

    private static boolean inBounds(int i,int j,int m,int n){
        return !(i < 0 || i >= m || j < 0 || j >= n);
    }
}