class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int i = 0,j = 0;
        int[] cnt = new int[256];
        int res = 0;
        while(j < n){
            char ch = s.charAt(j);
            cnt[ch]++;
            while(i <= j && cnt[ch] > 1){
                cnt[s.charAt(i)]--;
                i++;
            }
            res = Math.max(res,j-i+1);
            j++;
        }
        return res;
    }


    private static boolean checkValidity(int[] cnt){
        for(int i = 0;i < 256;i++){
            if(cnt[i] > 1) return false;
        }
        return true;
    }
}