class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        int n = happiness.length;
        int cnt = 0;
        long ans = 0l;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i : happiness) pq.add(i);
        while(!pq.isEmpty()){
            int curr = pq.poll();
            cnt++;
            if(cnt > k || curr - cnt + 1 <= 0) break;
            ans += (curr - cnt + 1);
        }
        return ans;
    }
}