class Solution {
    static String[] ans = new String[31];
    static{
        ans[1] = "1";
        StringBuilder sb = new StringBuilder();
        StringBuilder prev = new StringBuilder("1");
        for(int i = 2;i <= 30;i++){
            int x = prev.length();
            for(int j = 0;j < x;j++){
                int cnt = 1;
                int k = j+1;
                while(k < x && prev.charAt(j) == prev.charAt(k)){
                    cnt++;
                    k++;
                }
                sb.append(cnt);
                sb.append(prev.charAt(j));
                j = k-1;
            }
            ans[i] = sb.toString();
            prev.setLength(0);
            prev.append(sb);
            sb.setLength(0);
        }
    }
    public String countAndSay(int n) {
        return ans[n];
    }
}