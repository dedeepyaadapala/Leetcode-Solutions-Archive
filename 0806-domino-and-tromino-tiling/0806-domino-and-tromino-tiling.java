class Solution {
    static long[] tot;
    static{
        tot = new long[1001];
        tot[1] = 1;
        tot[2] = 2;
        tot[3] = 5;
        for(int i = 4;i <= 1000;i++){
            tot[i] = (2 * tot[i-1] + tot[i-3]) % 1000000007;
        }
    }
    public int numTilings(int n) {
        return (int)tot[n];
    }
}