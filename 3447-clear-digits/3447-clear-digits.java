class Solution {
    public String clearDigits(String s) {
        int n = s.length();
        StringBuilder sb = new StringBuilder(s);
        for(int i = 0;i < n;i++){
            char ch = s.charAt(i);
            if(ch >= '0' && ch <= '9'){
                int j = i-1;
                while(j >= 0){
                    if(s.charAt(j) < '0' || s.charAt(j) > '9' && sb.charAt(j) != ' '){
                        sb.setCharAt(j,' ');
                        break;
                    }
                    j--;
                }
            }
        }
        for(int i = 0;i < n;i++){
            if(sb.charAt(i) >= '0' && sb.charAt(i) <= '9' || sb.charAt(i) == ' '){
                sb.deleteCharAt(i);
                i--;
                n--;
            }
        }
        return sb.toString();
    }
}