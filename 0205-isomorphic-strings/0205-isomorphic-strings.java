class Solution {
    public boolean isIsomorphic(String s, String t) {
        char[] replacements = new char[256];
        boolean[] taken = new boolean[256];
        for(int i = 0;i < 256;i++){
            replacements[i] = ' ';
        }
        int n = s.length();
        for(int i = 0;i < n;i++){
            char ch = s.charAt(i);
            char ch1 = t.charAt(i);
            if(replacements[ch] == ' ' && !taken[ch1]){
                replacements[ch] = ch1;
                taken[ch1] = true;
            }
            if(ch1 != replacements[ch]){
                return false;
            }
        }
        return true;
    }
}