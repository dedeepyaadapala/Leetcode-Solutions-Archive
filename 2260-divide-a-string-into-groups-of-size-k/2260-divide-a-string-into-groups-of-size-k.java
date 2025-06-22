class Solution {
    public String[] divideString(String s, int k, char fill) {
        int n = s.length();
        String[] res = new String[(n+k-1)/k];
        for(int i = 0;i < (n+k-1)/k;i++){
            res[i] = s.substring(i*k,Math.min((i+1)*k,n));
        }
        for(int i = res[(n+k-1)/k - 1].length()+1;i <= k;i++){
            res[(n+k-1)/k - 1] += String.valueOf(fill);
        }
        return res;
    }
}