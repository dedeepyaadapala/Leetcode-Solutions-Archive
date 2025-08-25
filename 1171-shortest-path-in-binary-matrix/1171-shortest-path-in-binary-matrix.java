class Solution {
    static int[][] dij = new int[][]{{-1,0},{-1,1},{-1,-1},{0,-1},{0,1},{1,-1},{1,0},{1,1}};
    public int shortestPathBinaryMatrix(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        if(grid[0][0] == 1 || grid[m-1][n-1] == 1) return -1;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> (a[2] - b[2]));
        pq.add(new int[]{0,0,1});
        int[][] dist = new int[m][n];
        for(int i = 0;i < m;i++){
            Arrays.fill(dist[i],Integer.MAX_VALUE);
        }
        dist[0][0] = 1;
        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            for(int[] ij : dij){
                int ni = curr[0] + ij[0];
                int nj = curr[1] + ij[1];
                if(ni >= 0 && ni <m && nj >= 0 && nj < n && grid[ni][nj] == 0 && dist[curr[0]][curr[1]] + 1 < dist[ni][nj]){
                    dist[ni][nj] = dist[curr[0]][curr[1]] + 1;
                    pq.add(new int[]{ni,nj,dist[ni][nj]});
                }
            }
        }
        return dist[m-1][n-1] == Integer.MAX_VALUE ? -1 : dist[m-1][n-1];
    }
}