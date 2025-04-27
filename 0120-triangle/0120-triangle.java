class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n][];
        for(int i = 0;i < n;i++){
            dp[i] = new int[i+1];
        }
        for(int i = 0;i < n;i++){
            dp[n-1][i] = triangle.get(n-1).get(i);
        }
        for(int i = n-2;i >= 0;i--){
            // dp[i][0] = dp[i+1][0] + triangle.get(i).get(0);
            for(int j = 0;j <= i;j++){
                dp[i][j] = Math.min(dp[i+1][j],dp[i+1][j+1]) + triangle.get(i).get(j);
            }
        }
        return dp[0][0];
    }
}

// 1
// 1 2
// 1 2 3
// 1 2 3 4
// 1 2 3 4 5