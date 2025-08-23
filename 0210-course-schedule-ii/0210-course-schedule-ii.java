class Solution {
    public int[] findOrder(int n, int[][] prerequisites) {
        List<List<Integer>> lst = new ArrayList<>();
        for(int i = 0;i < n;i++){
            lst.add(new ArrayList<>());
        }
        for(int[] i : prerequisites){
            lst.get(i[1]).add(i[0]);
        }
        if(isCycle(lst,n)){
            return new int[]{};
        }
        int[] needed = new int[n];
        for(List<Integer> curr : lst){
            for(int i : curr){
                needed[i]++;
            }
        }
        int[] res = new int[n];
        int idx = 0;
        while(idx < n){
            for(int i = 0;i < n;i++){
                if(needed[i] == 0){
                    res[idx++] = i;
                    needed[i]--;
                    for(int course : lst.get(i)){
                        needed[course]--;
                    }
                }
            }
        }
        return res;
    }


    private static boolean isCycle(List<List<Integer>> lst,int n){
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
        for(int adj : lst.get(i)){
            if(dfs(lst,vis,path,adj)){
                return true;
            }
        }
        path[i] = false;
        return false;
    }
}