class Solution {
    public int minDifficulty(int[] jobDifficulty, int d) {
        int n = jobDifficulty.length;
        int[][] dp = new int[n][d];
        for(int i = 0;i < n;i++) Arrays.fill(dp[i],-1);
        generatePossibilities(jobDifficulty,n,0,d-1,dp);
        return dp[0][d-1] == -1 || dp[0][d-1] >= 1000000  ? -1 : dp[0][d-1];
    }

    private static int generatePossibilities(int[] jobs,int n,int idx,int days,int[][] dp){
        if(idx == n) return 1000000;
        if(days == 0){
            if(idx == n) return 1000000;
            int maxi = 0;
            for(int i = idx;i < n;i++){
                maxi = Math.max(maxi,jobs[i]);
            }
            return dp[idx][days] = maxi;
        }

        if(dp[idx][days] != -1) return dp[idx][days];
        int maxi = 0, sum = 1000000;
        for(int i = idx;i < n;i++){
            maxi = Math.max(maxi,jobs[i]);
            sum = Math.min(sum,maxi + generatePossibilities(jobs,n,i+1,days-1,dp));
        }
        return dp[idx][days] = sum;
    }
}