class Solution {
    public int maxDifference(String s) {
        int[] cnt = new int[26];
        int n = s.length();
        for(int i = 0;i < n;i++){
            cnt[s.charAt(i)-'a']++;
        }
        int maxi = Integer.MIN_VALUE;
        int mini = Integer.MAX_VALUE;
        for(int i = 0;i < 26;i++){
            if(cnt[i] != 0){
            if(cnt[i] % 2 == 0){
                mini = Math.min(mini,cnt[i]);
            }else{
                maxi = Math.max(maxi,cnt[i]);
            }}
        }
        return maxi - mini;
    }
}