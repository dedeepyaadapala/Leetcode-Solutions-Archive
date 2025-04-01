class Solution {
    public long mostPoints(int[][] questions) {
        int n = questions.length;
        long dp[] = new long[n];
        dp[n-1] = questions[n-1][0];
        for(int i = n-2;i >= 0;i--){
            int next = i + questions[i][1] + 1;
            if(next < n){
                dp[i] = Math.max(dp[next]+questions[i][0],dp[i+1]);
            }
            dp[i] = Math.max(dp[i+1],Math.max(questions[i][0],dp[i]));
        }
        long res = 0;
        for(int i = 0;i < n;i++){
            res = Math.max(res,dp[i]);
        }
        return res;
        // return findRes(questions,n,0,dp);
    }

    private static long findRes(int[][] questions,int n,int i,long[] dp){
        if(i >= n) return 0;
        if(dp[i] != 0) return dp[i];
        long pick = questions[i][0] + findRes(questions,n,i+questions[i][1]+1,dp);
        long notPick = findRes(questions,n,i+1,dp);
        return dp[i] = Math.max(pick,notPick);
    }
}


// 3+2 
// left = 1, right = 3,5