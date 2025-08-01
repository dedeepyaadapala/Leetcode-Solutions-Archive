class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] vis = new boolean[n];
        int cnt = 0;
        for(int i = 0;i < n;i++){
            if(!vis[i]){
                bfs(isConnected,n,i,vis);
                cnt++;
            }
        }
        return cnt;
    }

    private static void bfs(int[][] isConnected,int n,int src,boolean[] vis){
        Queue<Integer> q = new LinkedList<>();
        q.add(src);
        vis[src] = true;
        while(!q.isEmpty()){
            int curr = q.poll();
            for(int i = 0;i < n;i++){
                if(isConnected[curr][i] == 1 && !vis[i]){
                    q.add(i);
                    vis[i] = true;
                }
            }
        }
        return;
    }
}