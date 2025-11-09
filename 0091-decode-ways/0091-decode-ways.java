class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        int[] dp = new int[n];
        Arrays.fill(dp,-1);
        return decode(s,n,0,dp);
    }

    private static int decode(String s,int n,int idx,int[] dp){
        if(idx == n) return 1;
        if(dp[idx] != -1) return dp[idx];
        if(s.charAt(idx) == '0') return 0;
        int cnt1 = 0,cnt2 = 0;
        if(idx+1 < n){
            if(s.charAt(idx+1) == '0' && (s.charAt(idx) == '1' || s.charAt(idx) == '2')){
                return dp[idx] = decode(s,n,idx+2,dp);
            }
            if(Integer.valueOf(s.substring(idx,idx+2)) <= 26){
                cnt1 = decode(s,n,idx+2,dp);
            }
        }
        cnt2 = decode(s,n,idx+1,dp);
        return dp[idx] = cnt1 + cnt2;
    }
}