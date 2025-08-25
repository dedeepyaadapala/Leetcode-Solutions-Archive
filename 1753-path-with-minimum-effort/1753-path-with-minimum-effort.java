class Solution {
    static int[][] dij = new int[][]{{-1,0},{1,0},{0,-1},{0,1}};
    public int minimumEffortPath(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> (a[2] - b[2]));
        pq.add(new int[]{0,0,0});
        int[][] dist = new int[m][n];
        for(int i = 0;i < m;i++){
            Arrays.fill(dist[i],Integer.MAX_VALUE);
        }
        dist[0][0] = 0;
        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            for(int[] ij : dij){
                int ni = curr[0] + ij[0];
                int nj = curr[1] + ij[1];
                if(ni >= 0 && ni < m && nj >= 0 && nj < n && Math.max(curr[2],Math.abs(heights[ni][nj] - heights[curr[0]][curr[1]])) < dist[ni][nj]){
                    dist[ni][nj] = Math.max(curr[2],Math.abs(heights[ni][nj] - heights[curr[0]][curr[1]]));
                    dist[curr[0]][curr[1]] = Math.min(dist[curr[0]][curr[1]],dist[ni][nj]);
                    pq.add(new int[]{ni,nj,dist[ni][nj]});
                }
            }
        }
        return dist[m-1][n-1];
    }
}