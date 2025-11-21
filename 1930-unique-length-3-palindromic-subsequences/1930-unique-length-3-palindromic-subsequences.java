class Solution {
    public int countPalindromicSubsequence(String s) {
        int n = s.length();
        int[] first = new int[26];
        int[] last = new int[26];
        for(int i = 0;i < 26;i++){
            first[i] = -1;
            last[i] = -1;
        }
        for(int i = 0;i < n;i++){
            if(first[s.charAt(i)-'a'] == -1){
                first[s.charAt(i)-'a'] = i;
            }
            last[s.charAt(i)-'a'] = i;
        }
        int cnt = 0;
        for(int i = 0;i < 26;i++){
            if(first[i] != -1 && last[i] != -1 && first[i] != last[i]){
                HashSet<Character> set = new HashSet<>();
                for(int j = first[i]+1;j <= last[i]-1;j++){
                    set.add(s.charAt(j));
                }
                cnt += set.size();
            }
        }
        return cnt;
    }
}