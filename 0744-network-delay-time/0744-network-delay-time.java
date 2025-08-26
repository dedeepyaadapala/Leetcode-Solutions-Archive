class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<int[]>> adj = new ArrayList<>();
        for(int i = 0;i <= n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] time : times){
            adj.get(time[0]).add(new int[]{time[1],time[2]});
        }
        int[] vis = new int[n+1];
        Arrays.fill(vis,Integer.MAX_VALUE);
        vis[k] = 0;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{k,0});
        while(!q.isEmpty()){
            int[] curr = q.poll();
            for(int[] next : adj.get(curr[0])){
                if(vis[next[0]] > curr[1] + next[1]){
                    q.add(new int[]{next[0],curr[1] + next[1]});
                    vis[next[0]] = curr[1] + next[1];
                }
            }
        }
        int ans = 0;
        for(int i = 1;i <= n;i++){
            if(vis[i] == Integer.MAX_VALUE) return -1;
            ans = Math.max(ans,vis[i]);
        }
        return ans;
    }
}