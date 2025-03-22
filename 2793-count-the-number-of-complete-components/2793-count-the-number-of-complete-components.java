class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0;i < n;i++){
            graph.add(new ArrayList<>());
        }
        int m = edges.length;
        for(int i = 0;i < m;i++){
            graph.get(edges[i][0]).add(edges[i][1]);
            graph.get(edges[i][1]).add(edges[i][0]);
        }
        boolean[] visited = new boolean[n];
        int cnt = 0;
        for(int i = 0;i < n;i++){
            if(!visited[i]){
                if(bfs(graph,n,i,visited)){
                    cnt++;
                }
            }
        }
        return cnt;
    }

    private static boolean bfs(List<List<Integer>> graph,int n,int src,boolean[] visited){
        Queue<Integer> q = new LinkedList<>();
        q.add(src);
        visited[src] = true;
        int cnt = 0,edges = 0;
        while(!q.isEmpty()){
            int curr = q.poll();
            cnt++;
            for(int i : graph.get(curr)){
                edges++;
                if(!visited[i]){
                    q.add(i);
                    visited[i] = true;
                }
            }
        }
        return edges == (cnt * (cnt - 1));
    }
}