class Solution {

    public int numEquivDominoPairs(int[][] dominoes) {
        int[] cnt = new int[100];
        int n = dominoes.length;
        int res = 0;
        for(int i = 0;i < n;i++){
            int idx = dominoes[i][0] > dominoes[i][1] ? dominoes[i][1] * 10 + dominoes[i][0] : dominoes[i][0] * 10 + dominoes[i][1];
            res += cnt[idx];
            cnt[idx]++;
        }
        return res;
    }
}