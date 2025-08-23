class Solution {
    public boolean canFinish(int n, int[][] prerequisites) {
        List<List<Integer>> lst = new ArrayList<>();
        for(int i = 0;i < n;i++){
            lst.add(new ArrayList<>());
        }
        for(int[] i : prerequisites){
            lst.get(i[1]).add(i[0]);
        }
        return !isCyclic(lst,n);
    }

    private static boolean isCyclic(List<List<Integer>> lst,int n){
        boolean[] vis = new boolean[n];
        boolean[] path = new boolean[n];
        for(int i = 0;i < n;i++){
            if(!vis[i] && dfs(lst,vis,path,i)){
                return true;
            }
        }
        return false;
    }

    private static boolean dfs(List<List<Integer>> lst,boolean[] vis,boolean[] path,int i){
        if(vis[i]) return path[i];
        vis[i] = true;
        path[i] = true;
        for(int course : lst.get(i)){
            if(dfs(lst,vis,path,course)){
                return true;
            }
        }
        path[i] = false;
        return false;
    }
}