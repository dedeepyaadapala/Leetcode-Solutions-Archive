class Solution {
    public int lengthOfLongestSubstring(String s) {
        int len = 0,maxlen = 0;
        int n = s.length();
        for(int i = 0;i < n;i++){
            HashSet<Character> ss = new HashSet<>();
            len = 0;
            for(int j = i;j < n;j++){
                char ch = s.charAt(j);
                if(!ss.contains(ch)){
                    ss.add(ch);
                    len++;
                    maxlen = Math.max(len,maxlen);
                }else{
                    break;
                }
            }
        }
        return maxlen;
    }
}