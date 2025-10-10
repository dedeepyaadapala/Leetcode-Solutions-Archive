class Solution {
    public int minTimeToType(String word) {
        int mini = 0;
        char prev = 'a';
        int n = word.length();
        for(int i = 0;i < n;i++){
            char ch = word.charAt(i);
            mini = mini + Math.min((ch - prev + 26) % 26,(prev - ch + 26) % 26) + 1;
            prev = ch;
        }
        return mini;
    }
}