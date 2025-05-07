class Solution {
    static int[][] dij = new int[][]{{-1,0},{0,1},{1,0},{0,-1}};
    public int minTimeToReach(int[][] moveTime) {
        int n = moveTime.length;
        int m = moveTime[0].length;
        int[][] dp = new int[n][m];
        for(int i = 0;i < n;i++){
            Arrays.fill(dp[i],Integer.MAX_VALUE);
        }
        bfs(moveTime,n,m,dp);
        return dp[n-1][m-1];
    }

    static void bfs(int[][] moves,int n,int m,int[][] dp){
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>(){
            public int compare(int[] a,int[] b){
                return Integer.compare(a[2],b[2]);
            }
        });
        dp[0][0] = 0;
        pq.add(new int[]{0,0,0});
        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            for(int[] x : dij){
                int ni = curr[0]+x[0];
                int nj = curr[1]+x[1];
                if(ni >= 0 && ni < n && nj >= 0 && nj < m && Math.max(curr[2],moves[ni][nj])+1 < dp[ni][nj]){
                    dp[ni][nj] = Math.max(curr[2],moves[ni][nj])+1;
                    pq.add(new int[]{ni,nj,dp[ni][nj]});
                }
            }
        }
        return;
    }
}