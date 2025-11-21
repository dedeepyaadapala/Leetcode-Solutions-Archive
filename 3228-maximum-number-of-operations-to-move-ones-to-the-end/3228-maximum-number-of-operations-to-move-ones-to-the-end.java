class Solution {
    public int maxOperations(String s) {
        int n = s.length();
        int cnt = 0;
        int curr = 0;
        for(int i = 0;i < n;i++){
            if(s.charAt(i) == '1'){
                curr++;
            }else{
                int idx = i;
                while(i < n && s.charAt(i) == '0'){
                    i++;
                }
                if(idx != i) i--;
                cnt += curr;
            }
        }
        return cnt;
    }
}