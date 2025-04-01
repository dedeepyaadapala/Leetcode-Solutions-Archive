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

}


// 3+2 
// left = 1, right = 3,5