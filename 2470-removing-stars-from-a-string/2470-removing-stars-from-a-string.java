class Solution {
    public String removeStars(String s) {
        StringBuilder sb = new StringBuilder();
        int n = s.length();
        for(int i = 0;i < n;i++){
            char ch = s.charAt(i);
            if(ch == '*'){
                int x = sb.length();
                if(x > 0) sb.deleteCharAt(x-1);
            }else{
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}