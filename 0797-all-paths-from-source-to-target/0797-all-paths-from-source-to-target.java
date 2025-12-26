class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int n = graph.length;
        List<List<Integer>> ans = new ArrayList<>();
        dfs(graph,0,n-1,new boolean[n],ans,new ArrayList<>());
        return ans;
    }

    private static void dfs(int[][] graph,int src,int dest,boolean[] vis,List<List<Integer>> ans,List<Integer> curr){
        
        if(src == dest){
            curr.add(src);
            ans.add(new ArrayList<>(curr));
            curr.remove(curr.size()-1);
            return;
        }
        // if(vis[src]) return;
        vis[src] = true;
        curr.add(src);
        for(int i : graph[src]){
            if(!vis[i]){
                dfs(graph,i,dest,vis,ans,curr);
            }
        }
        curr.remove(curr.size()-1);
        vis[src] = false;
    }
}