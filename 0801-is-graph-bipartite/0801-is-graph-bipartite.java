class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] vis = new int[n];
        Arrays.fill(vis,-1);
        for(int i = 0;i < n;i++){
            if(vis[i] == -1){
                if(!bfs(graph,i,vis)) return false;
            }
        }
        return true;
    }

    private static boolean bfs(int[][] graph,int idx,int[] vis){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{idx,0});
        vis[idx] = 0;
        while(!q.isEmpty()){
            int[] curr = q.poll();
            for(int i : graph[curr[0]]){
                if(vis[i] == -1){
                    vis[i] = curr[1] ^ 1;
                    q.add(new int[]{i,vis[i]});
                }else{
                    if(vis[i] == curr[1]){
                        return false;
                    }
                }
            }
        }
        return true;
    }
}