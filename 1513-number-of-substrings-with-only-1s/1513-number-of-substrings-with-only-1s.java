class Solution {
    public int numSub(String s) {
        int n = s.length();
        long cnt = 0l;
        for(int i = 0;i < n;i++){
            int start = i;
            while(i < n && s.charAt(i) == '1'){
                i++;
            }
            long len = (i - start);
            cnt = (cnt + ((len * (len + 1)) / 2) % 1000000007) % 1000000007;
        }
        return (int)(cnt);
    }
}