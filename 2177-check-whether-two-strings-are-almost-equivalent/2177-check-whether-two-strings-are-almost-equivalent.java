class Solution {
    public boolean checkAlmostEquivalent(String word1, String word2) {
        int[] cnt = new int[26];
        int n = word1.length();
        for(int i = 0;i < n;i++){
            cnt[word1.charAt(i)-'a']++;
            cnt[word2.charAt(i)-'a']--;
        }
        for(int i = 0;i < 26;i++){
            if(Math.abs(cnt[i]) > 3) return false;
        }
        return true;
    }
}