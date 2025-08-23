class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        int[] vis = new int[n];
        boolean[] path = new boolean[n];
        Arrays.fill(vis,-1);
        for(int i = 0;i < n;i++){
            if(vis[i] == -1){
                vis[i] = dfs(graph,vis,path,i);
            }
        }
        List<Integer> safe = new ArrayList<>();
        for(int i = 0;i < n;i++){
            if(vis[i] == 1){
                safe.add(i);
            }
        }
        return safe;
    }


    private static int dfs(int[][] graph,int[] vis,boolean[] path,int i){
        if(vis[i] != -1){
            if(path[i]) return 0;
            return 1;
        }
        vis[i] = 1;
        path[i] = true;
        for(int adj : graph[i]){
            vis[adj] = dfs(graph,vis,path,adj);
            if(vis[adj] == 0) return 0;
        }
        path[i] = false;
        return 1;
    }
}