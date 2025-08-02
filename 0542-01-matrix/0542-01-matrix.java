class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] res = new int[m][n];
        Queue<int[]> q = new LinkedList<>();
        for(int i = 0;i < m;i++){
            Arrays.fill(res[i],-1);
            for(int j = 0;j < n;j++){
                if(mat[i][j] == 0){
                    q.add(new int[]{i,j});
                    res[i][j] = 0;
                }
            }
        }
        int[][] dist = new int[][]{{-1,0},{1,0},{0,-1},{0,1}};
        while(!q.isEmpty()){
            int[] curr = q.poll();
            for(int[] d : dist){
                int ni = curr[0] + d[0];
                int nj = curr[1] + d[1];
                if(ni >= 0 && ni < m && nj >= 0 && nj < n && res[ni][nj] == -1){
                    res[ni][nj] = res[curr[0]][curr[1]] + 1;
                    q.add(new int[]{ni,nj});
                }
            }
        }
        return res;
    }
}