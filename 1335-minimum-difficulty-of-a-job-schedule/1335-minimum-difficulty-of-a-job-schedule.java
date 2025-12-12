class Solution {
    public int minDifficulty(int[] jobDifficulty, int d) {
        int n = jobDifficulty.length;
        int maxi = 0;
        if(d == 1){
            for(int i = 0;i < n;i++){
                maxi = Math.max(maxi,jobDifficulty[i]);
            }
            return maxi;
        }
        int[][] dp = new int[n][d];
        for(int i = 0;i < n;i++) Arrays.fill(dp[i],-1);
        generatePossibilities(jobDifficulty,n,0,d-1,dp);
        // int ans = Integer.MAX_VALUE;
        // for(int i = 0;i < n;i++){
        //     for(int j = 0;j < d;j++){
        //         System.out.print(dp[i][j] +" ");
        //     }
        //     System.out.println();
        // }
        // for(int i = 0;i < n;i++){
        //     if(ans != -1 && ans < 1000000) ans = Math.min(ans,dp[i][d-1]);
        // }
        return dp[0][d-1] == -1 || dp[0][d-1] >= 1000000  ? -1 : dp[0][d-1];
    }

    private static int generatePossibilities(int[] jobs,int n,int idx,int days,int[][] dp){
        
        if(days == 0){
            if(idx == n) return 1000000;
            int maxi = 0;
            for(int i = idx;i < n;i++){
                maxi = Math.max(maxi,jobs[i]);
            }
            return maxi;
        }
        if(idx == n) return 1000000;

        if(dp[idx][days] != -1) return dp[idx][days];
        int maxi = 0, sum = 1000000;
        for(int i = idx;i < n;i++){
            maxi = Math.max(maxi,jobs[i]);
            sum = Math.min(sum,maxi + generatePossibilities(jobs,n,i+1,days-1,dp));
        }
        return dp[idx][days] = sum;
    }
}