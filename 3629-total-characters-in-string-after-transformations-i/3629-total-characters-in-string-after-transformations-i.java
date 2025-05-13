class Solution {
    public int lengthAfterTransformations(String s, int t) {
        int[] curr = new int[26];
        int n= s.length();
        for(int i = 0;i < n;i++){
            curr[s.charAt(i) - 'a']++;
        }
        for(int i = 0;i < t;i++){
            int[] next = new int[26];
            next[0] = curr[25];
            next[1] = (curr[25] + curr[0]) % 1_000_000_007;
            for(int j = 2;j < 26;j++){
                next[j] = curr[j-1];
            }
            curr = next;
        }
        int cnt = 0;
        for(int i = 0;i < 26;i++){
            cnt = (cnt +curr[i]) % 1_000_000_007;
        }
        return cnt;
    }
}