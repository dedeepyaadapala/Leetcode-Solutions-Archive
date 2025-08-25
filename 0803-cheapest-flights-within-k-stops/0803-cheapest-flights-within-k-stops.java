class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<int[]>> adj = new ArrayList<>();
        for(int i = 0;i < n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] flight : flights){
            adj.get(flight[0]).add(new int[]{flight[1],flight[2]});
        }
        int[] dist = new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> {
            if(a[2] != b[2]) return Integer.compare(a[2],b[2]);
            return (a[1] - b[1]);
        });
        pq.add(new int[]{src,0,0});
        dist[src] = 0;
        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            if(curr[2] > k){
                continue; 
            }
            for(int[] next : adj.get(curr[0])){
                if(next[1] + curr[1] < dist[next[0]]){
                    dist[next[0]] = next[1] + curr[1];
                    pq.add(new int[]{next[0],dist[next[0]],curr[2]+1});
                }
            }
        }
        return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];
    }
}