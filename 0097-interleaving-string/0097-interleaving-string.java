class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s3.length() != s1.length() +s2.length()) return false;
        int[][] dp = new int[s1.length()+1][s2.length()+1];
        for(int i = s1.length() - 1;i >= 0;i--){
            Arrays.fill(dp[i],-1);
        }
        return interleaving(s1,0,s1.length(),s2,0,s2.length(),s3,0,s3.length(),dp) == 1;
    }

    private static int interleaving(String s1,int idx1,int n1,String s2,int idx2,int n2,String s3,int idx3,int n3,int[][] dp){
        if(idx3 == n3) return 1;
        if(idx1 < n1 && idx2 < n2 && dp[idx1][idx2] != -1) return dp[idx1][idx2];
        int ans = 0;
        if(idx1 < n1 && s1.charAt(idx1) == s3.charAt(idx3)){
            ans = ans | (interleaving(s1,idx1+1,n1,s2,idx2,n2,s3,idx3+1,n3,dp));
        }
        if(idx2 < n2 && s2.charAt(idx2) == s3.charAt(idx3)){
            ans = ans | (interleaving(s1,idx1,n1,s2,idx2+1,n2,s3,idx3+1,n3,dp));
        }
        return dp[idx1][idx2] = ans;
    }
}