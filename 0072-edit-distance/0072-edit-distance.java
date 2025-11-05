class Solution {
    public int minDistance(String word1, String word2) {
        int n1 = word1.length();
        int n2 = word2.length();
        int[][] dp = new int[n1][n2];
        for(int i = 0;i < n1;i++){
            Arrays.fill(dp[i],-1);
        }
        return findDist(word1,n1,0,word2,n2,0,dp);
    }

    private static int findDist(String word1,int n1,int idx1,String word2,int n2,int idx2,int[][] dp){
        if(idx2 == n2){
            return n1 - idx1;
        }
        if(idx1 == n1){
            return n2 - idx2;
        }
        if(dp[idx1][idx2] != -1) return dp[idx1][idx2];
        int ins = 1 + findDist(word1,n1,idx1,word2,n2,idx2+1,dp);
        int del = 1 + findDist(word1,n1,idx1+1,word2,n2,idx2,dp);
        int rep = (word1.charAt(idx1) == word2.charAt(idx2) ? 0 : 1) + findDist(word1,n1,idx1+1,word2,n2,idx2+1,dp);
        return dp[idx1][idx2] = Math.min(ins,Math.min(del,rep));
    }
}