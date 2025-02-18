class Solution {
    public String smallestNumber(String pattern) {
        int n = pattern.length();
        boolean[] flag = new boolean[10];
        StringBuilder sb = new StringBuilder();
        backtrack(pattern,n,-1,flag,sb);
        return sb.toString();
    }

    private static boolean backtrack(String s,int n,int idx,boolean[] flag,StringBuilder sb){
        if(sb.length() == n+1){
            return true;
        }
        char ch = ' ';
            if(idx != -1) ch = s.charAt(idx);
            int start = 1,end = 9;
            if(idx != -1 && ch == 'I'){
                start = sb.charAt(sb.length()-1)-'0'+1;
            }
            if(idx != -1 && ch == 'D'){
                end = sb.charAt(sb.length()-1)-'0'-1;
            }
            for(int j = start;j <= end;j++){
                if(!flag[j]){
                    flag[j] = true;
                    sb.append(j);
                    if(backtrack(s,n,idx+1,flag,sb)) return true;
                    sb.deleteCharAt(sb.length()-1);
                    flag[j] = false;
                }
        }
        return false;
    }
}