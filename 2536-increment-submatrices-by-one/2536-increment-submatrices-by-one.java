class Solution {
    public int[][] rangeAddQueries(int n, int[][] queries) {
        int[][] res = new int[n][n];
        int len = queries.length;
        for(int i = 0;i < len;i++){
            int r1 = queries[i][0];
            int c1 = queries[i][1];
            int r2 = queries[i][2];
            int c2 = queries[i][3];
            for(int idx = r1;idx <= r2;idx++){
                res[idx][c1] += 1;
                if(c2 + 1 < n){
                    res[idx][c2 + 1] -= 1;
                }
            }
        }
        for(int i = 0;i < n;i++){
            for(int j = 1;j < n;j++){
                res[i][j] += res[i][j-1];
            }
        }
        // for(int i = 1;i < n;i++){
        //     for(int j = 0;j < n;j++){
        //         res[i][j] += res[i-1][j];
        //     }
        // }
        return res;
    }
}