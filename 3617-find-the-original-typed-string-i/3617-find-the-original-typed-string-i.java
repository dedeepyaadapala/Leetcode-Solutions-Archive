class Solution {
    public int possibleStringCount(String word) {
        int cnt = 0;
        int n = word.length();
        for(int i = 0;i < n;i++){
            cnt++;
            while(i < n-1 && word.charAt(i) == word.charAt(i+1)){
                i++;
            }
        }
        return n-cnt+1;
    }
}